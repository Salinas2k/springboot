package com.portal.springboot.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.portal.springboot.exception.ResourceNotFoundException;
import com.portal.springboot.model.Contact;
import com.portal.springboot.repository.ContactRepository;

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
@RequestMapping("/api/v1")
public class ContactController {
    @Autowired
    private ContactRepository contactRepository;

    @GetMapping("contacts")
    public List<Contact> getAllContacts() {
        return this.contactRepository.findAll();
    }

    @GetMapping("contact/{id}")
    public ResponseEntity<Contact> getContactById(@PathVariable(value = "id") Long contactId)
            throws ResourceNotFoundException {
        Contact contact = contactRepository.findById(contactId)
                .orElseThrow(() -> new ResourceNotFoundException("Contact not found for this id :: " + contactId));
        return ResponseEntity.ok().body(contact);
    }

    @PostMapping("contact")
    public Contact createActivities(@RequestBody Contact contact) {
        return contactRepository.save(contact);
    }

    @DeleteMapping("contact")
    public Map<String, Boolean> deleteContact(@PathVariable(value = "id") Long contactId)
            throws ResourceNotFoundException {
        Contact contact = contactRepository.findById(contactId)
                .orElseThrow(() -> new ResourceNotFoundException("Contact not found for this id :: " + contactId));

        contactRepository.delete(contact);
        Map<String, Boolean> response = new HashMap<>();
        response.put("deleted", Boolean.TRUE);
        return response;
    }
}
