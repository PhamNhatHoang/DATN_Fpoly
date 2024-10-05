package com.controller.service;

import com.controller.entity.Authority;
import com.controller.entity.User;
import com.controller.entity.DTO.AuthorityDTO;
import com.controller.repo.AuthorityRepo;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public interface AuthorityService {
	List<Authority> findAll();
	List<AuthorityDTO> findAllDto();
	Authority create (Authority authority);
	void delete(int id);
	void update (Authority authority);
}
