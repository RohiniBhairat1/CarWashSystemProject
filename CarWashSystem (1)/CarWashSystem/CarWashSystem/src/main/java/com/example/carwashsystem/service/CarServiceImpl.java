package com.example.carwashsystem.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.carwashsystem.entity.Car;
import com.example.carwashsystem.exceptions.NotFoundException;
import com.example.carwashsystem.repository.CarRepository;

@Service
public class CarServiceImpl implements CarService{

	CarRepository carRepo;
	@Autowired
	public CarServiceImpl(CarRepository carRepo) {
		this.carRepo = carRepo;
	}
	
	
	@Override
	public Car save(Car theCar) {
		
		/*Optional<Car> result = carRepo.findById(theCar.getCarId());
		if (result != null) {
			throw new NotFoundException("Already registerd, Try with different number ?");
		} else {
			Car car = carRepo.save(theCar);
			return car;
		}*/
		Car car = carRepo.save(theCar);
		return car;
		
	}

	@Override
	public List<Car> findAllCar() {
		List<Car> allCar = carRepo.findAll();
		if (allCar.size() == 0 ) {
			throw new NotFoundException("Car list is empty !!!");
		}
		
		return allCar;
	}

	@Override
	public Car updateCarById(Long theId, Car car) {
		Car result = findCarById(theId);
		if (result != null) {
			carRepo.save(car);
			return car;
		} else
			throw new NotFoundException("Car is not available !!!");

	}
	

	@Override
	public void deleteCarById(Long theId) {
		Optional<Car> result = carRepo.findById(theId);
		if (result != null)
			carRepo.deleteById(theId);

		else
			throw new NotFoundException("Car is not available !!!");
	
	}

	@Override
	public Car findCarByNumber(String number) {
		Car car = carRepo.findCarByNumber(number);
		if (car == null)
			throw new NotFoundException("Invalid Credential !!!");
		return car;
	}

	@Override
	public Car findCarByModel(String model) {
		Car car = carRepo.findCarByModel(model);
		if (car == null)
			throw new NotFoundException("Invalid Credential !!!");
		return car;
	}

	@Override
	public List<Car> findAllCarByIdInDesc() {
		List<Car> sortedByDescCar = carRepo.findAllByOrderByCarIdDesc();

		if (sortedByDescCar.size() == 0) {
			throw new NotFoundException("Car list is empty !!!");
		}
		return sortedByDescCar;
	}

	@Override
	public Car findCarById(Long id) {
		Optional<Car> result = carRepo.findById(id);

		Car car = null;
		if (result.isPresent()) {
			car = result.get();
		} else {
			throw new NotFoundException("Car not found !!, whose ID is " + id);
		}
		return car;
	}


}
