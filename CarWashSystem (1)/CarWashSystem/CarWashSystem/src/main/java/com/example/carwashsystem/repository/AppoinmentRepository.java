package com.example.carwashsystem.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.carwashsystem.entity.Appoinment;
@Repository
public interface AppoinmentRepository extends JpaRepository<Appoinment, Long> {

	public List<Appoinment> findAllByOrderByAppointmentIdDesc();


}
