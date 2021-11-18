package com.portal.springboot.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.portal.springboot.exception.ResourceNotFoundException;
import com.portal.springboot.model.Profile;
import com.portal.springboot.repository.ProfileRepository;

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
public class ProfileController {

	@Autowired
	private ProfileRepository profileRepository;
	
	@GetMapping("profile")
	public List<Profile> getAllProfiles(){
		return this.profileRepository.findAll();
	}
	
	@GetMapping("profile/{id}")
	public ResponseEntity<Profile> getProfileById(@PathVariable(value = "id") Long profileId)
			throws ResourceNotFoundException {
		Profile profile = profileRepository.findById(profileId)
				.orElseThrow(() -> new ResourceNotFoundException("Profile not found for this id :: " + profileId));
		return ResponseEntity.ok().body(profile);
	}
	
	@PostMapping("profile")
	public Profile createProfile(@RequestBody Profile profile) {
		return profileRepository.save(profile);
	}
	
	@PutMapping("profile/{id}")
	public ResponseEntity<Profile> updateProfile(@PathVariable(value = "id") Long profileId,
			@RequestBody Profile profileDetails) throws ResourceNotFoundException {
		Profile profile = profileRepository.findById(profileId)
				.orElseThrow(() -> new ResourceNotFoundException("Profile not found for this id :: " + profileId));
		
		profile.setId(profileDetails.getId());
		profile.setProfileId(profileDetails.getProfileId());
		profile.setDescription(profileDetails.getDescription());
		final Profile updatedProfile = profileRepository.save(profile);
		return ResponseEntity.ok(updatedProfile);
	}
	
	@DeleteMapping("profile/{id}")
	public Map<String, Boolean> deleteProfile(@PathVariable(value = "id") Long profileId)
			throws ResourceNotFoundException {
		Profile profile = profileRepository.findById(profileId)
				.orElseThrow(() -> new ResourceNotFoundException("Profile not found for this id :: " + profileId));
		
		profileRepository.delete(profile);
		Map<String, Boolean> response = new HashMap<>();
		response.put("deleted", Boolean.TRUE);
		return response;
	}
}
