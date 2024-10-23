package com.example.petshop.controller;

import com.example.petshop.entity.Pet;
import com.example.petshop.entity.Product;
import com.example.petshop.entity.SliderBar;
import com.example.petshop.entity.User;
import com.example.petshop.service.PetService;
import com.example.petshop.service.ProductService;
import com.example.petshop.service.SlideBarService;
import com.example.petshop.service.UserService;
import com.example.petshop.service.ServiceService;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import com.example.petshop.entity.Service;
import java.util.*;
import java.util.stream.Collectors;

@Controller
public class HomeController {
    @Autowired
    private UserService userService;

    @Autowired
    private ProductService productService;

    @Autowired
    private PetService petService;

    @Autowired
    private SlideBarService slideBarService;

    @ModelAttribute("fullname")
    public void getUser(Model model, HttpServletRequest request) {
        try {
            User user = userService.findByUsername(request.getUserPrincipal().getName());
            if (user != null) {
                model.addAttribute("user", user);
            }
        } catch (Exception e) {
            model.addAttribute("user", null);
        }
    }

    @RequestMapping({"/", "/trang-chu", "/home"})
    public String home(Model model) {
        //product
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

        //pet
        List<Pet> petsList = petService.getAll();
        Pet firstPet = petsList.stream()
                .max(Comparator.comparing(Pet::getPetID))
                .orElseThrow(() -> new NoSuchElementException("No product found"));
        Collection<Pet> nextSixPet = petsList.stream()
                .skip(1)
                .limit(6)
                .collect(Collectors.toList());
        model.addAttribute("firstPet", firstPet);
        model.addAttribute("nextSixPet", nextSixPet);
        model.addAttribute("slides", slideBarService.getAll());

        return "/layout/_main";
    }

    @RequestMapping("/cart-detail")
    public String cart(Model model) {
        return "/layout/_cartDetail";
    }

    @RequestMapping("/pet")
    public String pet(Model model) {
        return "/layout/_petDetail";
    }
    @RequestMapping("/service") 
    public String service(Model model) {
     
        return "/layout/_service"; 
    }
    @RequestMapping("/product")
    public String product(Model model) {
        return "/layout/_productDetaill";
    }

    @RequestMapping("/allPet")
    public String allPet(Model model) {
        List<Pet> list = petService.getAll();
        model.addAttribute("listPet", list);
        return "/layout/_allPet";
    }

    @RequestMapping("/allProduct")
    public String allProduct(Model model) {
        List<Product> list = productService.getAll();
        model.addAttribute("listProduct", list);
        return "/layout/_allProduct";
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
