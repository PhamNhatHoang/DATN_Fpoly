package com.example.petshop.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.petshop.entity.Authority;
import com.example.petshop.service.AuthorityService;

import java.util.List;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.PathVariable;


@CrossOrigin("*")
@RestController
@RequestMapping("api/authority")
public class AuthorityController {
	
	@Autowired
	AuthorityService service;
	
	@GetMapping
	public List<Authority> get() {
		return null;
	}
	
	@PostMapping
	public Authority post(@RequestBody Authority author) {
		return null;
	}
	
	@PutMapping("/{id}")
	public void put(@PathVariable int id, @RequestBody Authority authorUpdate) {
		
	}

	@DeleteMapping("/{id}")
	public void delete(@PathVariable int id) {
	}
}
