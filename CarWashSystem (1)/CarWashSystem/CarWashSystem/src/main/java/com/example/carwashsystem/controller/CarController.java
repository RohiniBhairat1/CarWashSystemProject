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
 
import com.example.carwashsystem.entity.Car;
import com.example.carwashsystem.repository.CarRepository;
import com.example.carwashsystem.service.CarService;


@CrossOrigin(origins = "http://localhost:4200",allowedHeaders = "*")
@RestController
@RequestMapping("/cars")
public class CarController {

	
	 @Autowired
	 CarService carService;
	 
	 CarRepository carRepository;
	 
	 @PostMapping("/cars")
	 private Car saveCart(@Validated @RequestBody Car theCar) {
             theCar.setCarId(0l);
			Car car = carService.save(theCar);	
			return car;
		}
	 
	 @GetMapping("/cars")  //Ok
		private List<Car> getAllStudent() {
			List<Car> carList = carService.findAllCar();
			return carList;
		}
	 @GetMapping("/cars/{id}") // Ok
		private Car getCarById(@PathVariable Long id) {
			Car car = carService.findCarById(id);
			return car;
		}
	 @GetMapping("/cars/{model}") // Ok
		private Car getCarByModel(@PathVariable String model) {
			Car car = carService.findCarByModel(model);
			return car;
		}

		@GetMapping("/cars/byDesc") // Ok
		private List<Car> findAllByOrderByIdDesc() {
			List<Car> sortedByDescCar = carService.findAllCarByIdInDesc();
			return sortedByDescCar;
		}
		
		@PutMapping("/cars/{id}")   // Ok
		private Car updateCar(@Validated @RequestBody Car car) {

			Car car1 = carService.findCarById(car.getCarId());

			System.out.println("OK");
			Car result = carService.updateCarById(car1.getCarId(), car);
			return result;
		}
		@DeleteMapping("/cars/{id}") // Ok
		private String deleteCar(@PathVariable Long id) {

			//Car car = carService.findCarById(id);
			
			carService.deleteCarById(id);
		
			return "deleted Car record"; 
		}
		@GetMapping("/cars/{number}") // Ok
		private Car getCarByNumber(@PathVariable String number) {
			Car car = carService.findCarByNumber(number);
			return car;
		}
}
