package com.example.petshop.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import java.util.List;
import java.util.stream.Collectors;

import com.example.petshop.entity.User;
import com.example.petshop.entity.DTO.UserDTO;
import com.example.petshop.service.UserService;
@CrossOrigin("*")
@RestController
@RequestMapping("/api/user")
public class RestUserController {
	@Autowired
	UserService service;
	
	
	//Tìm danh sách người dùng thông qua dto 
	@GetMapping("/getall")
	public List<UserDTO> getAll() {
	    // Lấy danh sách tất cả các user từ service
	    List<User> users = service.findAll();
	    
	    // Chuyển đổi danh sách User sang danh sách UserDTO
	    List<UserDTO> dtos = users.stream().map(user -> {
	        UserDTO dto = new UserDTO();
	        dto.setUserName(user.getUsername());
	        dto.setActiveToken(user.getActiveToken());
	        return dto;
	    }).collect(Collectors.toList());
	    return dtos;
	}
	
	//Hàm tìm người dùng thông qua active token
	@GetMapping("/getByToken/{token}")
	public UserDTO getByToken(@PathVariable String token) {
	    // Tìm user theo token
	    User user = service.findByToken(token);
	    
	    // Chuyển đổi đối tượng User sang UserDTO
	    UserDTO dto = new UserDTO();
	    dto.setUserName(user.getUsername());
	    dto.setActiveToken(user.getActiveToken());
	    return dto;
	}
	
	//Hàm đăng ký người dùng mặc định
	@PostMapping("/register")
	public User register(@RequestBody User user) {
		User newUser = service.create(user);
		return newUser;
	}
	
	//Kích hoạt tài khoản - setEnable = true -Làm thêm hàm check ngày đăng ký hoặc kích hoạt chưa
	@PutMapping("/confirmation")
	public UserDTO Confirmation(@RequestParam("confirmation_token") String confirmation_token) {
	    // Tìm user theo token
	    User user = service.findByToken(confirmation_token);
	    user.setEnable(true);
	    // Chuyển đổi đối tượng User sang UserDTO
	    UserDTO dto = new UserDTO();
	    dto.setEnable(user.getEnable());
	    dto.setActiveToken(user.getActiveToken());
	    
	    return dto;
	}

}
