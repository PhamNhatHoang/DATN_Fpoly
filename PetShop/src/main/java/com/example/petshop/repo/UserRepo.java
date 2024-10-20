package com.example.petshop.repo;

import com.example.petshop.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepo extends JpaRepository<User, String> {
    @Query("SELECT u FROM User u WHERE u.userName = :username")
    User findByUsername(String username);
    @Query("SELECT u FROM User u WHERE u.activeToken = :token")
    User findByToken(String token);
}
