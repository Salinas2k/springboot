package com.portal.springboot.repository;

import com.portal.springboot.model.Olt;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OltRepository extends JpaRepository<Olt, String> {

}
