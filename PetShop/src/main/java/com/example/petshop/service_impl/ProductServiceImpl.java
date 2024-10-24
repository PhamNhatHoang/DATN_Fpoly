package com.example.petshop.service_impl;

import com.example.petshop.entity.Product;
import com.example.petshop.repo.ProductRepo;
import com.example.petshop.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProductServiceImpl implements ProductService {
    @Autowired
    private ProductRepo productRepo;

    @Override
    public List<Product> getAll() {
        return productRepo.findAll();
    }

<<<<<<< HEAD
    @Override
    public Optional<Product> findById(Integer id) {
        return productRepo.findById(id);
    }

    @Override
    public void save(Product product) {
        productRepo.save(product);
    }

    @Override
    public void deleteById(Integer id) {
        productRepo.deleteById(id);
    }
=======
	@Override
	public Product getById(int id) {
		// TODO Auto-generated method stub
		return null;
	}

>>>>>>> origin/NhatHoang
}
