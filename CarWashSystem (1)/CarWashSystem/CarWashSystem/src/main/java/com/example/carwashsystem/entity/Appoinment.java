package com.example.carwashsystem.entity;

import java.time.LocalDate;
import java.time.LocalTime;

import org.springframework.format.annotation.DateTimeFormat;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;

@Entity
@Table(name="appointment")
public class Appoinment {

	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="appointment_Id")
	private Long appointmentId;
	@Temporal(TemporalType.TIME)
	@DateTimeFormat(style = "HH:mm")
	//@JsonFormat(shape=JsonFormat.Shape.STRING, pattern="HH:mm")
	@JsonDeserialize(using = TimeDeserializer.class)
    private LocalTime time;
    private String status;
    private LocalDate date;
	
    @ManyToOne
    @JoinColumn(name = "cust_Id")
    private Customer customer;

	public Long getAppointmentId() {
		return appointmentId;
	}

	public void setAppointmentId(Long appointmentId) {
		this.appointmentId = appointmentId;
	}

	public LocalTime getTime() {
		return time;
	}

	public void setTime(LocalTime time) {
		this.time = time;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public LocalDate getDate() {
		return date;
	}

	public void setDate(LocalDate date) {
		this.date = date;
	}

	public Customer getCustomer() {
		return customer;
	}

	public void setCustomer(Customer customer) {
		this.customer = customer;
	}

	public Appoinment() {
		super();
	}

	public Appoinment(Long appointmentId, LocalTime time, String status, LocalDate date, Customer customer) {
		super();
		this.appointmentId = appointmentId;
		this.time = time;
		this.status = status;
		this.date = date;
		this.customer = customer;
	}

	@Override
	public String toString() {
		return "Appoinment [appointmentId=" + appointmentId + ", time=" + time + ", status=" + status + ", date=" + date
				+ ", customer=" + customer + "]";
	}
    
    
    
}
