package com.ingemur.springboot.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ingemur.springboot.model.Roles;

@Repository
public interface RolesRepository extends JpaRepository<Roles, Long> {

}
