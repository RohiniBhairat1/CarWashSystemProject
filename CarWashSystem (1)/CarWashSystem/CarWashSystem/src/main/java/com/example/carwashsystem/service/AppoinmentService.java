package com.example.carwashsystem.service;

import java.util.List;

import com.example.carwashsystem.entity.Appoinment;

public interface AppoinmentService {
	
    public Appoinment save(Appoinment appoinments);
	
	public List<Appoinment> findAllAppoinments();	
	
	public Appoinment findAppoinmentById(Long id);
	
	public String deleteAppoinmentById(Long id);
	
	public List<Appoinment> findAllAppoinmentByIdInDesc();
	
	public Appoinment updateAppoinmentById(Long id, Appoinment appoinment);

}
