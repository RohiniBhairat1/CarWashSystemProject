package com.example.carwashsystem.service;

import java.util.List;


import com.example.carwashsystem.entity.Customer;

public interface CustomerService {

    public Customer save(Customer customer);
	
	public Customer update(Customer customer);
	
	public List<Customer> findAllCustomers();
	
    public Customer findByCustomerName(String name);
	
	public Customer findCustomerById(Long custId);
	
	public Customer deleteCustomerById(Long custId);
		
	public List<Customer> findAllByOrderByCustomerNameDesc();
	
	public List<Customer> findAllCustomerByIdInDesc();

	public Customer updateCustomerById(Long custId, Customer customer);
}