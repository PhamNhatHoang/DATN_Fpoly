package com.controller.controller;

import com.controller.entity.User;
import com.controller.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@Controller
public class HomeController {
    @Autowired
    private UserService userService;

    @RequestMapping("/")
    public String getUsers(Model model) {
        List<User> users = userService.findAll();
        return "home/index";
    }

    @RequestMapping("/login")
    public String login() {
        return "/security/login";
    }
}
