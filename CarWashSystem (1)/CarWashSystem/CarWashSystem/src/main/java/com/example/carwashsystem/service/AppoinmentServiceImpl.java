package com.example.carwashsystem.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.carwashsystem.entity.Appoinment;
import com.example.carwashsystem.exceptions.NotFoundException;
import com.example.carwashsystem.repository.AppoinmentRepository;



@Service
public class AppoinmentServiceImpl implements AppoinmentService {
	
	AppoinmentRepository appoinmentRepo;
	
	@Autowired
	public AppoinmentServiceImpl(AppoinmentRepository appoinmentRepo) {
		this.appoinmentRepo = appoinmentRepo;
	}


	@Override
	public Appoinment save(Appoinment appoinments) {
		Appoinment appointment = appoinmentRepo.save(appoinments);
		if (appointment == null) {
			throw new NotFoundException("Something Went Wrong");
		}
		return appointment;
	}

	@Override
	public List<Appoinment> findAllAppoinments() {
		List<Appoinment> appList = appoinmentRepo.findAll();
		if (appList.size() == 0)
			throw new NotFoundException("Currently list is empty !");
		return appList;
	}

	@Override
	public Appoinment findAppoinmentById(Long id) {
		Optional<Appoinment> result = appoinmentRepo.findById(id);

		Appoinment theApp = null;
		if (!result.isPresent()) {
			throw new NotFoundException(" Appointment not found !!!, whose id is  " + id);

		} else {
			theApp = result.get();
			return theApp;
		}
	}

	@Override
	public String deleteAppoinmentById(Long id) {
		 Appoinment  theApp = findAppoinmentById(id);

		if (theApp != null)
			appoinmentRepo.delete(theApp);
		else
			throw new NotFoundException("Appoinment not found!!!");
		return "Appoinment with "+id+"is deleted.";
	}

	@Override
	public List<Appoinment> findAllAppoinmentByIdInDesc() {
		List<Appoinment> sortedByDescAppoinment = appoinmentRepo.findAllByOrderByAppointmentIdDesc();

		if (sortedByDescAppoinment.size() == 0) {
			throw new NotFoundException("Car list is empty !!!");
		}
		return sortedByDescAppoinment;
	}


	@Override
	public Appoinment updateAppoinmentById(Long id, Appoinment appoinment) {
		Appoinment result = findAppoinmentById(id);
		if (result != null) {
			appoinmentRepo.save(appoinment);
			return appoinment;
		} else
			throw new NotFoundException("Appoinment  is not available !!!");
	}
	
}
