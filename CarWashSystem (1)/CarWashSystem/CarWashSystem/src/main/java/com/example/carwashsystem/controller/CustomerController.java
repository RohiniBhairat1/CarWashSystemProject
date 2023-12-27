package com.example.carwashsystem.controller;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.carwashsystem.entity.Customer;
import com.example.carwashsystem.service.CustomerService;

@CrossOrigin(origins = "http://localhost:4200",allowedHeaders = "*")
@RestController
@RequestMapping("/customers")

public class CustomerController {
	
	 @Autowired
	  CustomerService customerService;
	 
	 
	 @PostMapping("/customers")
		public Customer saveCustomer(@Validated @RequestBody Customer customer) {
		 Customer theCustomer = customerService.save(customer);
			return theCustomer;
		}

	  @GetMapping("/customers")
		public List<Customer> getAllCustomers() {
			List<Customer> customers = customerService.findAllCustomers();
			return customers;	
		}
	  @GetMapping("/customers/{id}") // Ok
		private Customer getCustomerById(@PathVariable Long custId) {
		  Customer customer = customerService.findCustomerById(custId);
			return customer;
		}
	 /* @GetMapping("/customers/{email}") // Ok
			private Customer getCustomerByEmail(@PathVariable String email) {
			  Customer customer = customerService.findCustomerById(custId);
				return customer;
			} */

		@PutMapping("/customers/{id}")   // Ok
		private Customer updateCustomer( @Validated@RequestBody Customer customer) {

			Customer customer1 = customerService.findCustomerById(customer.getCustId());

			System.out.println("OK");
			Customer result = customerService.updateCustomerById(customer1.getCustId(), customer);
			return result;
		}
		@DeleteMapping("/customers/{id}") // Ok
		private String deleteProfessor(@PathVariable Long custId) {
			
			//Customer customer = customerService.findCustomerById(custId);
			
			customerService.deleteCustomerById(custId);
		
			return "deleted Customer record"; 
		}

		@GetMapping("/customers/byDesc") // Ok
		private List<Customer> findAllByOrderByIdDesc() {
			List<Customer> sortedByDescCustomer = customerService.findAllCustomerByIdInDesc();
			return sortedByDescCustomer;
		}
		
}
