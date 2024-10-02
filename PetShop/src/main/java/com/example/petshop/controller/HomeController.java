package com.example.petshop.controller;

import com.example.petshop.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class HomeController {
    @Autowired
    private UserService userService;

    @RequestMapping({"/", "/trang-chu", "/home"})
    public String home(Model model) {
        return "index";
    }

    @RequestMapping("/cart-detail")
    public String cart(Model model) {
        return "_cartDetail";
    }

    @RequestMapping("/login")
    public String login(Model model,
                        @RequestParam(value = "error", required = false) boolean error,
                        @RequestParam(value = "success", required = false) boolean success) {
        if (error) {
            model.addAttribute("message", "Đăng nhập thất bại!");
            model.addAttribute("loginStatus", false);
        }
        if (success) {
            model.addAttribute("message", "Đăng nhập thành công!");
            model.addAttribute("loginStatus", true);
        }
        return "security/login";
    }
    @RequestMapping("/access-denied")
    public String accessDenied(Model model) {
        return "security/access-denied";
    }
}
