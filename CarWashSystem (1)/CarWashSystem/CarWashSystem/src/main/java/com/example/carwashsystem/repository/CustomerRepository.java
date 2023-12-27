package com.example.carwashsystem.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.carwashsystem.entity.Customer;
@Repository
public interface CustomerRepository extends JpaRepository<Customer, Long> {

	public Customer findByName(String name);

	public List<Customer> findAllByOrderByNameDesc();

	//public List<Customer> findByEmailId(String emailId);
	
	public List<Customer> findByCustId(Long custId);
	
	public List<Customer> findAllByOrderByCustIdDesc();

}
