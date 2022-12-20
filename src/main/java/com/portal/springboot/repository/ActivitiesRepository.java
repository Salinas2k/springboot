package com.portal.springboot.repository;

import com.portal.springboot.model.Activities;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ActivitiesRepository extends JpaRepository<Activities, Long> {

}
