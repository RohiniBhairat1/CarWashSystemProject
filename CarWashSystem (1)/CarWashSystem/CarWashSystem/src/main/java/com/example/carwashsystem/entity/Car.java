package com.example.carwashsystem.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

@Entity
public class Car {

	    @Id
	    @GeneratedValue(strategy = GenerationType.IDENTITY)
	
	 private Long carId;
	    private String color;
	    private String model;
	    private String number;
	    
	    
	    @ManyToOne
	    @JoinColumn(name = "cust_Id")
	    private Customer customer;


		public Long getCarId() {
			return carId;
		}


		public void setCarId(Long carId) {
			this.carId = carId;
		}


		public String getColor() {
			return color;
		}


		public void setColor(String color) {
			this.color = color;
		}


		public String getModel() {
			return model;
		}


		public void setModel(String model) {
			this.model = model;
		}


		public String getNumber() {
			return number;
		}


		public void setNumber(String number) {
			this.number = number;
		}


		public Customer getCustomer() {
			return customer;
		}


		public void setCustomer(Customer customer) {
			this.customer = customer;
		}


		public Car(Long carId, String color, String model, String number, Customer customer) {
			super();
			this.carId = carId;
			this.color = color;
			this.model = model;
			this.number = number;
			this.customer = customer;
		}


		public Car() {
			super();
		}


		@Override
		public String toString() {
			return "Car [carId=" + carId + ", color=" + color + ", model=" + model + ", number=" + number
					+ ", customer=" + customer + "]";
		}




		
	    
	    
}
