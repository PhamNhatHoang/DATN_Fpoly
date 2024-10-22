package com.example.petshop.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.time.Instant;
import java.util.List;
import java.util.Set;
import java.util.UUID;
import java.util.stream.Collectors;

import com.example.petshop.config.MailerService;
import com.example.petshop.entity.Authority;
import com.example.petshop.entity.Role;
import com.example.petshop.entity.User;
import com.example.petshop.entity.DTO.UserDTO;
import com.example.petshop.service.AuthorityService;
import com.example.petshop.service.RoleService;
import com.example.petshop.service.UserService;

import jakarta.transaction.Transactional;
@CrossOrigin("*")
@RestController
@RequestMapping("/api/user")
public class RestUserController {
	@Autowired
	UserService service;
	@Autowired
	RoleService roleService;
	@Autowired
	AuthorityService authorityService;
	MailerService mailerService;
	
	//Tìm danh sách người dùng thông qua dto 
	@GetMapping("/getall")
	public List<UserDTO> getAll() {
	    List<User> users = service.findAll();
	    List<UserDTO> dtos = users.stream().map(user -> {
	        UserDTO dto = new UserDTO();
	        dto.setUserName(user.getUsername());
	        dto.setActiveToken(user.getActiveToken());
	        dto.setEnable(user.getEnable());
	        dto.setDateCreated(user.getDateCreated());

	        // Chuyển Set<Authority> thành một chuỗi các authority
	        Set<Authority> authorities = user.getAuthorities();
	        if (authorities != null && !authorities.isEmpty()) {
	            String authIDs = authorities.stream()
	                                        .map(authority -> authority.getAuthority())  // Lấy tên quyền từ role
	                                        .collect(Collectors.joining(", "));  // Nối các quyền bằng dấu phẩy
	            dto.setAuthID(authIDs);  // Cập nhật danh sách quyền vào DTO
	        }
	        
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
	
	//Đăng ký
	@PostMapping("/register")
	public ResponseEntity<Object> register(@RequestBody User user) {
	    try {
	        // Kiểm tra xem tên đăng nhập đã tồn tại chưa
	        if (service.existedByUsername(user.getUsername())) {
	            return ResponseEntity.status(HttpStatus.CONFLICT)
	                    .body("{\"success\": false, \"message\": \"Tên đăng nhập đã tồn tại\"}");
	        }

	        // Mã hóa mật khẩu người dùng
	        BCryptPasswordEncoder bCryptPasswordEncoder = new BCryptPasswordEncoder();
	        String encodedPassword = bCryptPasswordEncoder.encode(user.getPassword());
	        mailerService = new MailerService();
	        
	        // Tạo mã thông báo và thiết lập thông tin người dùng
	        UUID uuid = UUID.randomUUID();
	        String uuidString = uuid.toString();
	        user.setActiveToken(uuidString);
	        user.setUserPassword(encodedPassword);
	        user.setDateCreated(Instant.now());

	        // Gán vai trò cho người dùng
	        Role role = roleService.findById("USER");
	        if (role == null) {
	            throw new RuntimeException("Role not found!");
	        }

	        // Tạo quyền và gán cho người dùng
	        Authority authority = new Authority();
	        authority.setRole(role);
	        authority.setUserName(user);
	        user.getAuthorities().add(authority);

	        // Lưu người dùng và quyền
	        User newUser = service.create(user);
	        Authority newAuthority = authorityService.create(authority);

	        // Chuyển đổi người dùng mới thành UserDTO
	        UserDTO newUserDto = new UserDTO(newUser);

	        // Gửi email xác nhận
	        mailerService.sendEmail(
	                user.getEmail(),
	                "Pet Shop",
	                "Confirm your email",
	                user.getFullName(),
	                user.getActiveToken()
	        );

	        // Trả về người dùng mới với mã trạng thái HTTP 201 (Created)
	        return new ResponseEntity<>(newUserDto, HttpStatus.CREATED);

	    } catch (Exception e) {
	        // Ghi lại lỗi và trả về trạng thái 400 Bad Request
	        System.err.println("Error during registration: " + e.getMessage());
	        return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
	    }
	}

	//Đường dẫn kích hoạt tài khoản
	@PutMapping("/confirmation")
	public ResponseEntity<?> Confirmation(@RequestParam("confirmation_token") String confirmation_token) {
	    // Tìm user theo token
	    User user = service.findByToken(confirmation_token);
	    
	    // Nếu không tìm thấy user, trả về lỗi
	    if (user == null) {
	        return ResponseEntity.status(HttpStatus.NOT_FOUND)
	                .body("{\"success\": false, \"message\": \"User không tồn tại hoặc token không hợp lệ\"}");
	    }

	    // Kiểm tra xem tài khoản đã được kích hoạt chưa
	    if (user.getEnable()) {
	        return ResponseEntity.status(HttpStatus.BAD_REQUEST)
	                .body("{\"success\": false, \"message\": \"Tài khoản đã được kích hoạt trước đó\"}");
	    }

	    // Kích hoạt tài khoản
	    user.setEnable(true);
	    service.update(user);

	    // Chuyển đổi đối tượng User sang UserDTO để trả về thông tin người dùng
	    UserDTO dto = new UserDTO();
	    dto.setEnable(user.getEnable());
	    dto.setActiveToken(user.getActiveToken());

	    // Trả về ResponseEntity với mã trạng thái OK
	    return ResponseEntity.ok(dto);
	}

	//Quên mật khấu
	@PutMapping("/forgot-password")
	public ResponseEntity<Object> forgotPassword(@PathVariable String username){
		
		return new ResponseEntity<>(null, HttpStatus.OK);
	}

	//login-with-facebook
	@PostMapping("/login-with-facebook")
	public ResponseEntity<Object> loginWithFacebook(@RequestBody User user){
		System.out.println(user);
		return new ResponseEntity<>(null, HttpStatus.ACCEPTED);
	}
	
	@DeleteMapping("/delete/{name}")
	public ResponseEntity<Object> delete(@PathVariable String name){
		System.out.println(name);
		return new ResponseEntity<>(null, HttpStatus.ACCEPTED);
	}
}
