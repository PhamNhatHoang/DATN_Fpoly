package com.example.petshop.controller;

import com.example.petshop.entity.Product;
import com.example.petshop.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@CrossOrigin("*")
@RequestMapping("/api/product")
@RestController
public class ProductController {

    @Autowired
    private ProductService productService;

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
}
