package com.example.petshop.controller;

<<<<<<< HEAD
import com.example.petshop.entity.Product;
import com.example.petshop.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@CrossOrigin("*")
@RequestMapping("/api/product")
@RestController
=======
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
>>>>>>> origin/NhatHoang
public class ProductController {

    @Autowired
    private ProductService productService;

<<<<<<< HEAD
    // Lấy danh sách tất cả sản phẩm
    @GetMapping
    public List<Product> getAllProducts() {
        return productService.getAll();
    }

    // Lấy thông tin sản phẩm theo ID
    @GetMapping("/{id}")
    public Optional<Product> getProductById(@PathVariable("id") Integer id) {
        return productService.findById(id);
    }

    // Thêm một sản phẩm mới
    @PostMapping
    public void addProduct(@RequestBody Product product) {
        productService.save(product);
    }

    // Cập nhật thông tin sản phẩm
    @PutMapping("/{id}")
    public void updateProduct(@PathVariable("id") Integer id, @RequestBody Product product) {
        product.setId(id);
        productService.save(product);
    }

    // Xóa một sản phẩm
    @DeleteMapping("/{id}")
    public void deleteProduct(@PathVariable("id") Integer id) {
        productService.deleteById(id);
    }
=======
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

>>>>>>> origin/NhatHoang
}
