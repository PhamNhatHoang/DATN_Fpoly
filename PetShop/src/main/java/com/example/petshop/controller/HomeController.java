package com.example.petshop.controller;

import com.example.petshop.entity.Product;
import com.example.petshop.service.ProductService;
import com.example.petshop.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.*;
import java.util.stream.Collectors;

@Controller
public class HomeController {
    @Autowired
    private UserService userService;

    @Autowired
    private ProductService productService;

    @RequestMapping({"/", "/trang-chu", "/home"})
    public String home(Model model) {
        List<Product> productsList = productService.getAll();
        Product latestProduct = productsList.stream()
                .max(Comparator.comparingInt(Product::getId))
                .orElseThrow(() -> new NoSuchElementException("No product found"));
        Collection<Product> nextSixProducts = productsList.stream()
                .skip(1)
                .limit(6)
                .collect(Collectors.toList());
        model.addAttribute("firstProduct", latestProduct);
        model.addAttribute("nextSixProducts", nextSixProducts);
        return "/layout/_main";
    }

    @RequestMapping("/cart-detail")
    public String cart(Model model) {
        return "/layout/_cartDetail";
    }

    @RequestMapping("/pet")
    public String pet(Model model) {
        return "_petDetail";
    }

    @RequestMapping("/product")
    public String product(Model model) {
        return "_productDetaill";
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

    @RequestMapping("/admin")
    public String admin(Model model) {
        return "_product";
    }

}
