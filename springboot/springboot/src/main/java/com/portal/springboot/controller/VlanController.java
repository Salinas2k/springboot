package com.portal.springboot.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.portal.springboot.exception.ResourceNotFoundException;
import com.portal.springboot.model.Vlan;
import com.portal.springboot.repository.VlanRepository;

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

@RestController
@RequestMapping("/api/v1/")
public class VlanController {
	
	@Autowired
	private VlanRepository vlanRepository;
	
	@GetMapping("vlan")
	public List<Vlan> getAllVlans() {
		return this.vlanRepository.findAll();
	}
	
	@PostMapping("vlan")
	public Vlan createVlan(@RequestBody Vlan port) {
		return vlanRepository.save(port);
	}
	
	@PutMapping("vlan/{id}")
	public ResponseEntity<Vlan> updateVlan (@PathVariable(value = "id") Integer vlanId,
		@RequestBody Vlan vlanDetails) throws ResourceNotFoundException {
		Vlan vlan = vlanRepository.findById(vlanId)
				.orElseThrow(() -> new ResourceNotFoundException("Vlan not found for this id :: " + vlanId));
		
		vlan.setId(vlanDetails.getId());
		vlan.setDescription(vlanDetails.getDescription());
		final Vlan updatedVlan = vlanRepository.save(vlan);
		return ResponseEntity.ok(updatedVlan);
	}
	
	@DeleteMapping("vlan/{id}")
	public Map<String, Boolean> deleteVlan(@PathVariable(value = "id") Integer vlanId)
		throws ResourceNotFoundException {
		Vlan vlan = vlanRepository.findById(vlanId)
				.orElseThrow(() -> new ResourceNotFoundException("Vlan not found for this id :: " + vlanId));
		
		vlanRepository.delete(vlan);
		Map<String, Boolean> response = new HashMap<>();
		response.put("deleted",Boolean.TRUE);
		return response;
	}

}
