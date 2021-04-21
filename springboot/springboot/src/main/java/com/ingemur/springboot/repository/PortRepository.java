package com.ingemur.springboot.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ingemur.springboot.model.Port;
import com.ingemur.springboot.model.PortId;

public interface PortRepository extends JpaRepository<Port, PortId>{

	
}
