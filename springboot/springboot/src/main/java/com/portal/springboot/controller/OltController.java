package com.portal.springboot.controller;

import java.util.List;

import com.portal.springboot.exception.ResourceNotFoundException;
import com.portal.springboot.model.Olt;
import com.portal.springboot.repository.OltRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/")
public class OltController {

	@Autowired
	private OltRepository oltRepository;

	@GetMapping("olt")
	public List<Olt> getAllOlt() {
		return oltRepository.findAll();
	}

	@PostMapping("olt")
	public Olt getOltById(@RequestBody Olt olt) {
		return oltRepository.save(olt);
	}

	@GetMapping("olt/{ip_address}")
	public ResponseEntity<Olt> getOltById(@PathVariable(value = "ip_address") String id)
			throws ResourceNotFoundException {
		Olt olt = oltRepository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("Olt not found for this id :: " + id));
		return ResponseEntity.ok(olt);
	}
}
