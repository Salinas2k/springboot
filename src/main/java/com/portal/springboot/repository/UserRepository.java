package com.portal.springboot.repository;

import com.portal.springboot.model.User;

import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, String> {
	User findByUsername(String username);
}
