package com.ingemur.springboot.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ingemur.springboot.exception.ResourceNotFoundException;
import com.ingemur.springboot.model.Port;
import com.ingemur.springboot.model.PortId;
import com.ingemur.springboot.repository.PortRepository;

@RestController
@RequestMapping("/api/v1/")
public class PortController {
	
	@Autowired
	private PortRepository portRepository;

	@GetMapping("ports")
	public List<Port> getAllPorts() {
		return this.portRepository.findAll();
	}
	
	@PostMapping("port")
	public Port createPort(@RequestBody Port port) {
		return portRepository.save(port);
	}
	
	@PutMapping("port/{id}")
	public ResponseEntity<Port> updatePort (@PathVariable(value = "id") PortId portId,
		@RequestBody Port portDetails) throws ResourceNotFoundException {
		Port port = portRepository.findById(portId)
				.orElseThrow(() -> new ResourceNotFoundException("Port not found for this id :: " + portId));
		
		port.setId(portDetails.getId());
		port.setOlt(portDetails.getOlt());
		port.setSlot(portDetails.getSlot());
		port.setPon(portDetails.getPon());
		port.setDescription(portDetails.getDescription());
		final Port updatedPort = portRepository.save(port);
		return ResponseEntity.ok(updatedPort);
	}
	
	@DeleteMapping("port/{id}")
	public Map<String, Boolean> deletePort(@PathVariable(value = "id") PortId portId)
		throws ResourceNotFoundException {
		Port port = portRepository.findById(portId)
				.orElseThrow(() -> new ResourceNotFoundException("Port not found for this id :: " + portId));
		
		portRepository.delete(port);
		Map<String, Boolean> response = new HashMap<>();
		response.put("deleted",Boolean.TRUE);
		return response;
	}
}
