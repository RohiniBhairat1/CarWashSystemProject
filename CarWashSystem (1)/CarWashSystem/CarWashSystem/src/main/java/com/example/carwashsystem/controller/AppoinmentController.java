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

import com.example.carwashsystem.entity.Appoinment;
import com.example.carwashsystem.service.AppoinmentService;

@CrossOrigin(origins = "http://localhost:4200", allowedHeaders = "*")
@RestController
@RequestMapping("/appoinment")
public class AppoinmentController {

	@Autowired
	AppoinmentService appoinmentService;

	@PostMapping("/appoinments") // Ok
	private Appoinment saveAppointment(@Validated @RequestBody Appoinment App) {

		Appoinment theApp = appoinmentService.save(App);

		return theApp;
	}

	@GetMapping("/appoinments") // Ok
	public List<Appoinment> getAllAppoinments() {
		List<Appoinment> allAppoinments = appoinmentService.findAllAppoinments();
		return allAppoinments;
	}

	@GetMapping("/appoinments/{id}")
	public Appoinment getAppoinmentById(@PathVariable Long id) {
		Appoinment app = appoinmentService.findAppoinmentById(id);
		return app;
	}
	/*
	@GetMapping("/appoinments/{date}")
	public Appoinment getAppoinmentByStatus(@PathVariable String status) {
		Appoinment app = appoinmentService.findAppoinmentById(null);
		return app;
	}
	*/

	@GetMapping("/appoinments/byDesc") // Ok
	private List<Appoinment> findAllByOrderByIdDesc() {
		List<Appoinment> sortedByDescAppoinment = appoinmentService.findAllAppoinmentByIdInDesc();
		return sortedByDescAppoinment;
	}

	@PutMapping("/appoinments")
	public Appoinment upadteAppoinment(@RequestBody Appoinment app) {

		Appoinment result = appoinmentService.save(app);

		System.err.println("Updated");
		return result;
	}
	@DeleteMapping("/appoinments/{id}") // Ok
	private String deleteStudent(@PathVariable Long id) {
		//Appoinment app = appoinmentService.findAppoinmentById(id);
		appoinmentService.deleteAppoinmentById(id);
		return "deleted Car record"; 
	}
}
