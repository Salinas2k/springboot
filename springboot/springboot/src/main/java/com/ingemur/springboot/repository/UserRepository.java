package com.ingemur.springboot.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ingemur.springboot.model.User;

public interface UserRepository extends JpaRepository<User, String> {
	User findByUsername(String username);
}
