package com.portal.springboot.repository;

import com.portal.springboot.model.Port;
import com.portal.springboot.model.PortId;

import org.springframework.data.jpa.repository.JpaRepository;

public interface PortRepository extends JpaRepository<Port, PortId>{

	
}
