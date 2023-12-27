package com.example.carwashsystem.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.carwashsystem.entity.Car;
@Repository
public interface CarRepository extends JpaRepository<Car, Long> {

	public Car findCarByNumber(String number);

	public Car findCarByModel(String model);
	
	public List<Car> findAllByOrderByCarIdAsc();
	
	public List<Car> findAllByOrderByCarIdDesc();
	

}
