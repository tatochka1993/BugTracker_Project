package org.tatsiana.webapp.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.tatsiana.webapp.entity.Issue;
import org.tatsiana.webapp.service.IssueService;

@Controller
@RequestMapping("/user")
public class UserController {

    @Autowired
    private IssueService issueService;


    @RequestMapping(value = "/issues", method = RequestMethod.GET)
    public String getIssuesPage(Model model) {
        model.addAttribute("issues", issueService.getAllIssues());
        return "user/issues";
    }

    @RequestMapping(value = "/issues", method = RequestMethod.GET, params = {"create"})
    public String getIssueEmptyForm(Model model) {
        model.addAttribute("issue", new Issue());
        return "user/issue_form";
    }

    @RequestMapping(value = "/issues", method = RequestMethod.GET, params = {"id"})
    public String getExistIssueForm(Model model, long id) {
        model.addAttribute("issue", issueService.getById(id));
        return "user/issue_form";
    }

    @RequestMapping(value = "/issues", method = RequestMethod.GET, params = {"id", "delete"})
    public String deleteIssue(long id) {
        issueService.deleteIssue(id);
        return "redirect:/user/issues";
    }

    @RequestMapping(value = "/issues", method = RequestMethod.POST, params = {"save"})
    public String getExistIssueForm(Issue issue, BindingResult result) {
        if (result.hasErrors()) {
            return "user/issue_form";
        }
        issueService.saveIssue(issue);
        return "redirect:/user/issues";
    }

}
