package com.example.carwashsystem.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.carwashsystem.entity.Invoice;
@Repository
public interface InvoiceRepository extends JpaRepository<Invoice, Long> {

	public List<Invoice> findAllByOrderByInvoiceIdDesc();

	


}
