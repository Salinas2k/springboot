package com.ingemur.springboot.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ingemur.springboot.model.Profile;

public interface ProfileRepository extends JpaRepository<Profile, Long>{

}
