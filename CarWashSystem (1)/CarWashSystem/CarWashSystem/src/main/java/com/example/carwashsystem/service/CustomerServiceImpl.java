package com.example.carwashsystem.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.carwashsystem.entity.Customer;
import com.example.carwashsystem.exceptions.NotFoundException;
import com.example.carwashsystem.repository.CustomerRepository;
@Service
public class CustomerServiceImpl implements CustomerService {
	
	CustomerRepository customerRepository;
	
	@Autowired
	public CustomerServiceImpl(CustomerRepository customerRepository) {
		this.customerRepository = customerRepository;
	}

	@Override
	public Customer save(Customer customer) {
		Customer result = customerRepository.findByName(customer.getName());
		if (result != null) {
			throw new NotFoundException("Professor-name is already registerd, Try with different name ?");
		} else {
			Customer  customers= customerRepository.save(customer);
			return customers;
		}
	}

	@Override
	public Customer update(Customer customer) {
		Customer customers = customerRepository.save(customer);
			return customers;
	}

	@Override
	public List<Customer> findAllCustomers() {
		List<Customer> customers = customerRepository.findAll();
		if (customers.size() == 0) {
			throw new NotFoundException("List is empty !!");
		}
		return customers;
	}

	@Override
	public Customer findByCustomerName(String name) {
		Customer customer = customerRepository.findByName(name);
		if (customer == null) {
			throw new NotFoundException("Customer not found !!!");
		}
		return customer;
	}

	@Override
	public Customer findCustomerById(Long custId) {
		Optional<Customer> result = customerRepository.findById(custId);

		Customer theCustomer = null;
		if (result != null) {
				theCustomer= result.get();
			return theCustomer;
		} else
			throw new NotFoundException("Customer is not available whose id is " + custId);
	}

	@Override
	public Customer deleteCustomerById(Long custId) {
		Customer theCustomer = findCustomerById(custId);

		if( theCustomer != null) {
			customerRepository.delete(theCustomer);
			return theCustomer;
		} else
			throw new NotFoundException("Customer is not available whose id is " + custId);
	}

	@Override
	public List<Customer> findAllByOrderByCustomerNameDesc() {
		List<Customer> customers = customerRepository.findAllByOrderByNameDesc();

		if (customers.size() == 0) {
			throw new NotFoundException("List is empty !!");
		}
		return customers;
	}

	@Override
	public List<Customer> findAllCustomerByIdInDesc() {
		List<Customer> sortedByDescCustomer = customerRepository.findAllByOrderByCustIdDesc();

		if (sortedByDescCustomer.size() == 0) {
			throw new NotFoundException("Customer list is empty !!!");
		}
		return sortedByDescCustomer;
	}

	@Override
	public Customer updateCustomerById(Long custId, Customer customer) {
		Customer result = findCustomerById(custId);
		if (result != null) {
			customerRepository.save(customer);
			return customer;
		} else
			throw new NotFoundException("Customer  is not available !!!");
	}

}
