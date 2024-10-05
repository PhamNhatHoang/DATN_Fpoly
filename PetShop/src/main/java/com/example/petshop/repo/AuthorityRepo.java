package com.example.petshop.repo;

import com.example.petshop.entity.Authority;
import com.example.petshop.entity.AuthorityId;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AuthorityRepo extends JpaRepository<Authority, AuthorityId> {
}
