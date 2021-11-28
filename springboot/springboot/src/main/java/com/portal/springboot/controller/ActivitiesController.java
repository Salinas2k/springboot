package com.portal.springboot.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.portal.springboot.exception.ResourceNotFoundException;
import com.portal.springboot.model.Activities;
import com.portal.springboot.repository.ActivitiesRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/")
public class ActivitiesController {

    @Autowired
    private ActivitiesRepository activitiesRepository;

    @GetMapping("activities")
    public List<Activities> getAllActivities() {
        return this.activitiesRepository.findAll();
    }

    @GetMapping("activities/{id}")
    public ResponseEntity<Activities> getActivitiesById(@PathVariable(value = "id") Long activityId)
            throws ResourceNotFoundException {
        Activities activity = activitiesRepository.findById(activityId)
                .orElseThrow(() -> new ResourceNotFoundException("Activity not found for this id :: " + activityId));
        return ResponseEntity.ok().body(activity);
    }

    @PostMapping("activities")
    public Activities createActivities(@RequestBody Activities activities) {
        return activitiesRepository.save(activities);
    }

    @DeleteMapping("activities")
    public Map<String, Boolean> deleteActivity(@PathVariable(value = "id") Long activityId)
            throws ResourceNotFoundException {
        Activities activity = activitiesRepository.findById(activityId)
                .orElseThrow(() -> new ResourceNotFoundException("Activity not found for this id :: " + activityId));

        activitiesRepository.delete(activity);
        Map<String, Boolean> response = new HashMap<>();
        response.put("deleted", Boolean.TRUE);
        return response;
    }
}
