package com.example.carwashsystem.service;

import java.util.List;

import com.example.carwashsystem.entity.Car;



public interface CarService {
	public Car save(Car theCar);
	public List<Car> findAllCar();
	public Car updateCarById(Long theId,Car car);
	public void deleteCarById(Long theId);
	public Car findCarByNumber(String number);
	public Car findCarByModel(String model);
	public List<Car> findAllCarByIdInDesc();
	public Car findCarById(Long id);
	
	

	
}
