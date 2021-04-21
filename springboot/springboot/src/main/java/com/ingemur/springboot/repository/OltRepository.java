package com.ingemur.springboot.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ingemur.springboot.model.Olt;

@Repository
public interface OltRepository extends JpaRepository<Olt, String> {

}
