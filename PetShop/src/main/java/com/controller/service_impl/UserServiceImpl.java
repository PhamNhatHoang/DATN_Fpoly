package com.controller.service_impl;

import com.controller.entity.User;
import com.controller.entity.DTO.UserDTO;
import com.controller.repo.UserRepo;
import com.controller.service.UserService;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {
	@Autowired
	UserRepo repo;
	
	@Override
	public List<UserDTO> findAll() {
        return repo.findAll().stream()
                .map(user -> new UserDTO(
                    user.getUserName(),
                    user.isEnable(),
                    user.getActiveToken(),
                    user.getDateCreated(),
                    user.getAuthority() != null ? user.getAuthority().getAuthID() : null
                ))
                .collect(Collectors.toList());
    
		
	}

	@Override
	public User create(User user) {
		return repo.save(user);
	}

	@Override
	public void delete(String username) {
		repo.deleteById(username);
	}

	@Override
	public void update(User user) {
		repo.save(user);
	}

	@Override
	public User findByUsername(String username) {
		return repo.findByUserName(username)
				.orElse(null);
	}

	@Override
	public boolean existedByUsername(String username) {
		return repo.existsById(username);
	}

	@Override
	public boolean existedByUsernameAndPassword(String username, String password) {
		return repo.existsByUserNameAndUserPassword(username, password);
	}
}
