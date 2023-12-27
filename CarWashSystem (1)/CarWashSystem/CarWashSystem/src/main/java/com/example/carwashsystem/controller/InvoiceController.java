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


import com.example.carwashsystem.entity.Invoice;
import com.example.carwashsystem.service.InvoiceService;

@CrossOrigin(origins = "http://localhost:4200", allowedHeaders = "*")
@RestController
@RequestMapping("/invoice")
public class InvoiceController {

	 @Autowired
	 private InvoiceService invoiceService;
	 
	 @PostMapping("/invoices") // Ok
		private Invoice saveInvoice(@Validated @RequestBody Invoice invoice) {

		 Invoice theinvoice = invoiceService.save(invoice);

			return theinvoice;
		}
	 @GetMapping("/invoices") // Ok
		public List<Invoice> getAllInvoices() {
			List<Invoice> allInvoices = invoiceService.findAllInvoices();
			return allInvoices;
		}

		@GetMapping("/invoices/{id}")
		public Invoice getInvoiceById(@PathVariable Long invoiceId) {
			Invoice invoice = invoiceService.findInvoiceById(invoiceId);
			return invoice;
		}
		@GetMapping("/invoices/byDesc") // Ok
		private List<Invoice> findAllByOrderByIdDesc() {
			List<Invoice> sortedByDescInvoice = invoiceService.findAllInvoiceByIdInDesc();
			return sortedByDescInvoice;
		}

		@PutMapping("/invoices")
		public Invoice updateInvoice(@RequestBody Invoice invoice) {

			Invoice result = invoiceService.save(invoice);

			System.err.println("Updated");
			return result;
		}
		@DeleteMapping("/invoices/{id}") // Ok
		private String deleteStudent(@PathVariable Long invoiceId) {
			//Appoinment app = appoinmentService.findAppoinmentById(id);
			invoiceService.deleteInvoiceById(invoiceId);
			return "deleted Car record"; 
		}
}
