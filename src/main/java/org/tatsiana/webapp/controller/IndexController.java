package org.tatsiana.webapp.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.tatsiana.webapp.service.UserService;
import org.tatsiana.webapp.util.UserUtil;

import java.security.Principal;

@Controller
public class IndexController {

    @Autowired
    private UserService userService;


    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String getStartPage(Principal principal) {
        return principal != null
                ? "redirect:/user/issues"
                : "login";
    }

    @RequestMapping(value = "/login", method = RequestMethod.GET)
    public String getLoginPage(@RequestParam(required = false) String error,
                               @RequestParam(required = false) String logout,
                               Model model) {
        model.addAttribute("isError", error != null);
        model.addAttribute("isLogout", logout != null);

        return "login";
    }

    @RequestMapping(value = "/register", method = RequestMethod.GET)
    public String getRegisterPage(@RequestParam(required = false) String code,
                                  Model model) {
        model.addAttribute("code", code);
        return "register";
    }

    @RequestMapping(value = "/register", method = RequestMethod.POST)
    public String proceedRegistration(Model model, String login, String password, String confirmPassword) {
        boolean isValid = UserUtil.validateUserCredentials(login, password, confirmPassword);
        String msg = "ERROR";

        if (isValid) {
            userService.createUserAccount(login.trim().toLowerCase(), password.trim());
            msg = "SUCCESS";
        }
        model.addAttribute("code", msg);

        return "redirect:/register";
    }

}
