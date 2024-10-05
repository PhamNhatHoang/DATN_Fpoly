package com.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import com.controller.entity.Authority;
import com.controller.service.AuthorityService;
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
		return service.findAll();
	}
	
	@PostMapping
	public Authority post(@RequestBody Authority author) {
		Authority newAuthor = service.create(author);
		return newAuthor;
	}
	
	@PutMapping("/{id}")
	public void put(@PathVariable int id, @RequestBody Authority authorUpdate) {
		if(id != authorUpdate.getAuthID()) {
			System.out.println("(Tam): Cập nhật Lỗi");
		}
		service.update(authorUpdate);
		System.out.println("(Tam): Cập nhật User với " + id + " thành công");
		
	}

	@DeleteMapping("/{id}")
	public void delete(@PathVariable int id) {
		service.delete(id);
	}
}
