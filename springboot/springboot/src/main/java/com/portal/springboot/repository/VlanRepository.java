package com.portal.springboot.repository;

import com.portal.springboot.model.Vlan;

import org.springframework.data.jpa.repository.JpaRepository;

public interface VlanRepository extends JpaRepository<Vlan, Integer>{

}
