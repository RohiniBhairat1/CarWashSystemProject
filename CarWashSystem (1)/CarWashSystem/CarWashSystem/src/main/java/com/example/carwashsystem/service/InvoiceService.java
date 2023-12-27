package com.example.carwashsystem.service;

import java.util.List;

import com.example.carwashsystem.entity.Invoice;

public interface InvoiceService {
	
     public Invoice save(Invoice invoices);
	
	public List<Invoice> findAllInvoices();	
	
	public Invoice findInvoiceById(Long invoiceid);
	
	public Invoice findInvoiceByPaymentId(Long paymentid);
	
	public String deleteInvoiceById(Long invoiceid);
	
	public List<Invoice> findAllInvoiceByIdInDesc();

	public Invoice updateInvoiceById(Long invoiceid, Invoice invoice);


}
