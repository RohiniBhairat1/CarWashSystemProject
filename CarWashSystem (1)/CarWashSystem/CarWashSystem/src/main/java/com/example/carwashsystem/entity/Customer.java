package com.example.carwashsystem.entity;

import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;

@Entity

public class Customer {

	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="cust_Id")
	 private Long custId;
	    private String mobileNo;
	    private String name;
	    private String emailId;
	    private String address;
	    
	    
	    @OneToMany(mappedBy = "customer")
	    private List<Car> cars = new ArrayList<>();


	   public Long getCustId() {
			return custId;
		}


		public void setCustId(Long custId) {
			this.custId = custId;
		}


		public String getMobileNo() {
			return mobileNo;
		}


		public void setMobileNo(String mobileNo) {
			this.mobileNo = mobileNo;
		}


		public String getName() {
			return name;
		}


		public void setName(String name) {
			this.name = name;
		}


		public String getEmailId() {
			return emailId;
		}


		public void setEmailId(String emailId) {
			this.emailId = emailId;
		}


		public String getAddress() {
			return address;
		}


		public void setAddress(String address) {
			this.address = address;
		}


		/*public List<Car> getCars() {
			return cars;
		}
          */

		public void setCars(List<Car> cars) {
			this.cars = cars;
		}


		public Customer() {
			super();
		}


		public Customer(Long custId, String mobileNo, String name, String emailId, String address, List<Car> cars) {
			super();
			this.custId = custId;
			this.mobileNo = mobileNo;
			this.name = name;
			this.emailId = emailId;
			this.address = address;
			this.cars = cars;
		}


		@Override
		public String toString() {
			return "Customer [custId=" + custId + ", mobileNo=" + mobileNo + ", name=" + name + ", emailId=" + emailId
					+ ", address=" + address + ", cars=" + cars + "]";
		}
	    
	    
	    
}
