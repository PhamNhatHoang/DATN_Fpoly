package com.example.petshop.controller;

import com.example.petshop.entity.User;
import com.example.petshop.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.w3c.dom.stylesheets.LinkStyle;

import java.util.List;

@Controller
public class HomeController {
    @Autowired
    private UserService userService;

    @RequestMapping({"/", "/trang-chu", "/home"})
    public String home(Model model) {
        List<User> userList = userService.findAll();
        model.addAttribute("userList", userList);
        return "home";
    }
}
