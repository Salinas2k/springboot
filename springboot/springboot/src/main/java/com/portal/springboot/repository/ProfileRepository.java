package com.portal.springboot.repository;

import com.portal.springboot.model.Profile;

import org.springframework.data.jpa.repository.JpaRepository;

public interface ProfileRepository extends JpaRepository<Profile, Long>{

}
