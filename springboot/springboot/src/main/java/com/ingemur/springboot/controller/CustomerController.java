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
import com.ingemur.springboot.model.Customer;
import com.ingemur.springboot.repository.CustomerRepository;

@RestController
@RequestMapping("/api/v1/")
public class CustomerController {

	@Autowired
	private CustomerRepository customerRepository;
	
	@GetMapping("customers")
	public List<Customer> getAllCustomers() {
		return this.customerRepository.findAll();
	}
	
	@GetMapping("customers/{id}")
	public ResponseEntity<Customer> getCustomerById(@PathVariable(value = "id") Long customerId)
			throws ResourceNotFoundException {
		Customer customer = customerRepository.findById(customerId)
				.orElseThrow(() -> new ResourceNotFoundException("Customer not found for this id :: " + customerId));
		return ResponseEntity.ok().body(customer);
	}
	
	@PostMapping("customers")
    public Customer createCustomer(@RequestBody Customer customer) {
        return customerRepository.save(customer);
    }
	
	@PutMapping("customers/{id}")
    public ResponseEntity<Customer> updateCustomer(@PathVariable(value = "id") Long customerId,
    		@RequestBody Customer customerDetails) throws ResourceNotFoundException {
        Customer customer = customerRepository.findById(customerId)
        .orElseThrow(() -> new ResourceNotFoundException("Customer not found for this id :: " + customerId));

        customer.setMail(customerDetails.getMail());
        customer.setAddress(customerDetails.getAddress());
        customer.setName(customerDetails.getName());
        customer.setPoblation(customerDetails.getPoblation());
        customer.setProvince(customerDetails.getProvince());
        final Customer updatedCustomer = customerRepository.save(customer);
        return ResponseEntity.ok(updatedCustomer);
    }
	
	@DeleteMapping("customers/{id}")
    public Map<String, Boolean> deleteCustomer(@PathVariable(value = "id") Long customerId)
        throws ResourceNotFoundException {
        Customer customer = customerRepository.findById(customerId)
        .orElseThrow(() -> new ResourceNotFoundException("Customer not found for this id :: " + customerId));

       customerRepository.delete(customer);
       Map<String, Boolean> response = new HashMap<>();
       response.put("deleted", Boolean.TRUE);
       return response;
    }
	
}
