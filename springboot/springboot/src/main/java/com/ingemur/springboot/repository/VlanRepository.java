package com.ingemur.springboot.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ingemur.springboot.model.Vlan;

public interface VlanRepository extends JpaRepository<Vlan, Integer>{

}
