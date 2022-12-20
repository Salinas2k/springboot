package com.portal.springboot.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.portal.springboot.exception.ResourceNotFoundException;
import com.portal.springboot.model.Subscription;
import com.portal.springboot.repository.SubscriptionRepository;

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
public class SubscriptionController {

    @Autowired
    private SubscriptionRepository subscriptionRepository;

    @GetMapping("subscription")
    public List<Subscription> getAllSubscription() {
        return this.subscriptionRepository.findAll();
    }

    @GetMapping("subscription/{id}")
    public ResponseEntity<Subscription> getSubscriptionById(@PathVariable(value = "id") Long subscriptionId)
            throws ResourceNotFoundException {
        Subscription subscription = subscriptionRepository.findById(subscriptionId)
                .orElseThrow(
                        () -> new ResourceNotFoundException("subscription not found for this id :: " + subscriptionId));
        return ResponseEntity.ok().body(subscription);
    }

    @PostMapping("subscription")
    public Subscription createSubscription(@RequestBody Subscription subscription) {
        return subscriptionRepository.save(subscription);
    }

    @DeleteMapping("subscription")
    public Map<String, Boolean> deleteSubscription(@PathVariable(value = "id") Long subscriptionId)
            throws ResourceNotFoundException {
        Subscription subscription = subscriptionRepository.findById(subscriptionId)
                .orElseThrow(
                        () -> new ResourceNotFoundException("subscription not found for this id :: " + subscriptionId));

        subscriptionRepository.delete(subscription);
        Map<String, Boolean> response = new HashMap<>();
        response.put("deleted", Boolean.TRUE);
        return response;
    }
}
