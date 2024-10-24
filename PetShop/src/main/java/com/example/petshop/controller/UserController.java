package com.example.petshop.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.petshop.entity.User;
import com.example.petshop.entity.DTO.UserDTO;
import com.example.petshop.service.UserService;

import java.util.List;

@CrossOrigin("*")
@RestController
@RequestMapping("api/user")
public class UserController {
	
	@Autowired
	UserService service;
	
	@GetMapping
	public List<UserDTO> get() {
		return null;
	}
	
	
	@GetMapping("/{username}")
	public User getByUsername(@PathVariable("username") String username) {
		return null;
	}
	
	@GetMapping("/{username}/{password}")
	public boolean checklogin(@PathVariable("username") String username,@PathVariable("password") String password ) {
		return true;
	}
	
	@PostMapping
	public User post(@RequestBody User user) {
		return null;
	}
	
	@PutMapping("/{username}")
	public void put(@RequestBody User userUpdate, @PathVariable String username) {
	
	}
	
	@PutMapping("/{username}/{token}")
	public void activeToken(@RequestBody User userActive,@PathVariable String username,@PathVariable String token) {
	}
	
	@DeleteMapping("/{username}")
	public void delete(@PathVariable String username) {
	}
}
