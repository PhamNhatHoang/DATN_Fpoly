package com.controller.service;
import java.util.List;
import org.springframework.stereotype.Service;

import com.controller.entity.User;
import com.controller.entity.DTO.UserDTO;

@Service
public interface UserService {
	List<UserDTO> findAll();
	User create (User user);
	void delete(String username);
	void update (User user);
	User findByUsername(String username);
	boolean existedByUsername(String username);
	boolean existedByUsernameAndPassword(String username, String password);
}
