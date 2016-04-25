package org.tatsiana.webapp.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.tatsiana.webapp.entity.User;
import org.tatsiana.webapp.service.RoleService;
import org.tatsiana.webapp.service.UserService;

@Controller
@RequestMapping("/admin")
public class AdminController {

    @Autowired
    private UserService userService;

    @Autowired
    private RoleService roleService;


    @RequestMapping(value = "/users", method = RequestMethod.GET)
    public String getIssuesPage(Model model) {
        model.addAttribute("users", userService.getAllUsers());
        return "admin/users";
    }

    @RequestMapping(value = "/users", method = RequestMethod.GET, params = {"id"})
    public String getUserFormPage(Model model, long id) {
        model.addAttribute("user", userService.getById(id));
        model.addAttribute("roles", roleService.getAllRoles());
        return "admin/user_form";
    }

    @RequestMapping(value = "/users", method = RequestMethod.POST, params = {"id"})
    public String proceedUserForm(User user, BindingResult result) {
        userService.saveUser(user);
        return "redirect:/admin/users";
    }

}
