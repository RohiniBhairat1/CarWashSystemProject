package com.example.carwashsystem.entity;

import java.math.BigDecimal;
import java.time.LocalDate;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

@Entity
public class Invoice {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long invoiceId;
	private LocalDate dateIssued;
	private BigDecimal totalAmount;
	private String paymentId;

	@ManyToOne
	@JoinColumn(name = "custId")
	private Customer customer;

	public Long getInvoiceId() {
		return invoiceId;
	}

	public void setInvoiceId(Long invoiceId) {
		this.invoiceId = invoiceId;
	}

	public LocalDate getDateIssued() {
		return dateIssued;
	}

	public void setDateIssued(LocalDate dateIssued) {
		this.dateIssued = dateIssued;
	}

	public BigDecimal getTotalAmount() {
		return totalAmount;
	}

	public void setTotalAmount(BigDecimal totalAmount) {
		this.totalAmount = totalAmount;
	}

	public String getPaymentId() {
		return paymentId;
	}

	public void setPaymentId(String paymentId) {
		this.paymentId = paymentId;
	}

	public Customer getCustomer() {
		return customer;
	}

	public void setCustomer(Customer customer) {
		this.customer = customer;
	}

	public Invoice() {
		super();
	}

	public Invoice(Long invoiceId, LocalDate dateIssued, BigDecimal totalAmount, String paymentId, Customer customer) {
		super();
		this.invoiceId = invoiceId;
		this.dateIssued = dateIssued;
		this.totalAmount = totalAmount;
		this.paymentId = paymentId;
		this.customer = customer;
	}

	@Override
	public String toString() {
		return "Invoice [invoiceId=" + invoiceId + ", dateIssued=" + dateIssued + ", totalAmount=" + totalAmount
				+ ", paymentId=" + paymentId + ", customer=" + customer + "]";
	}

}
