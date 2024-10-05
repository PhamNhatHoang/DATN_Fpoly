package com.controller.repo;

import com.controller.entity.User;

import java.util.Optional;

import org.springframework.data.jdbc.repository.query.Query;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepo extends JpaRepository<User, String> {
	Optional<User> findByUserName(String username);
	
	@Query("SELECT CASE WHEN COUNT(u) > 0 THEN true ELSE false END FROM User u WHERE u.userName = :username AND u.userPassword = :password")
    boolean existsByUserNameAndUserPassword(@Param("username") String username, @Param("password") String password);
}
