package com.controller.service_impl;

import com.controller.entity.Authority;
import com.controller.entity.DTO.AuthorityDTO;
import com.controller.repo.AuthorityRepo;
import com.controller.service.AuthorityService;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AuthorityServiceImpl implements AuthorityService {
    @Autowired
    private AuthorityRepo repo;

	@Override
	public List<Authority> findAll() {
		return repo.findAll() ;
	}
	
	@Override
	public List<AuthorityDTO> findAllDto() {
		return repo.findAll().stream()
				.map(autho -> new AuthorityDTO(
						autho.getAuthID(),
						autho.getRoleName()
						))
				.collect(Collectors.toList());
	}

	@Override
	public Authority create(Authority authority) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void delete(int id) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void update(Authority authority) {
		// TODO Auto-generated method stub
		
	}

	
}
