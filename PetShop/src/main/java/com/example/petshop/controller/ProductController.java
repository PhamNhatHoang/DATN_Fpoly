package com.example.petshop.controller;

import com.example.petshop.entity.Pet;
import com.example.petshop.entity.Product;
import com.example.petshop.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;
import java.util.stream.Collectors;

@Controller
public class ProductController {

    @Autowired
    private ProductService productService;

    @GetMapping("/product/detail/{id}")
    public String getPetDetail(@PathVariable("id") Integer id, Model model) {
        List<Product> product = productService.getAll();
        List<Product> limitedProducts = product.stream()
                .limit(6)
                .collect(Collectors.toList());
        Product detailProducts = productService.getById(id);
        model.addAttribute("products", limitedProducts);
        model.addAttribute("detailProducts", detailProducts);

        return "/layout/_productDetail";
    }

}
