package com.controller;

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
import java.util.List;

import com.controller.entity.User;
import com.controller.entity.DTO.UserDTO;
import com.controller.service.UserService;

@CrossOrigin("*")
@RestController
@RequestMapping("api/user")
public class UserController {
	
	@Autowired
	UserService service;
	
	@GetMapping
	public List<UserDTO> get() {
		return service.findAll();
	}
	
	
	@GetMapping("/{username}")
	public User getByUsername(@PathVariable("username") String username) {
		return service.findByUsername(username);
	}
	
	@GetMapping("/{username}/{password}")
	public boolean checklogin(@PathVariable("username") String username,@PathVariable("password") String password ) {
		return service.existedByUsernameAndPassword(username,password);
	}
	
	@PostMapping
	public User post(@RequestBody User user) {
		User newUser = service.create(user);
		return newUser;
	}
	
	@PutMapping("/{username}")
	public void put(@RequestBody User userUpdate, @PathVariable String username) {
		if(username != userUpdate.getUserName()) {
			System.out.println("(Tam): Lỗi");
		}
		service.update(userUpdate);
		System.out.println("(Tam): Cập nhật User với " + username + " thành công");
	}
	
	@PutMapping("/{username}/{token}")
	public void activeToken(@RequestBody User userActive,@PathVariable String username,@PathVariable String token) {
		if(username != userActive.getUserName() || token != userActive.getActiveToken()) {
			System.out.println("(Tam): Lỗi");
		}
		service.update(userActive);
		System.out.println("(Tam): Cập nhật User với " + username + " thành công");
	}
	
	@DeleteMapping("/{username}")
	public void delete(@PathVariable String username) {
		service.delete(username);
	}
}
