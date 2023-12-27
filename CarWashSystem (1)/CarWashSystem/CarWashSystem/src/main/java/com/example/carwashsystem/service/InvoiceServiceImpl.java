package com.example.carwashsystem.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.carwashsystem.entity.Invoice;
import com.example.carwashsystem.exceptions.NotFoundException;
import com.example.carwashsystem.repository.InvoiceRepository;
@Service
public class InvoiceServiceImpl implements InvoiceService {
	
	InvoiceRepository invoiceRepository;

	@Autowired
	public 	InvoiceServiceImpl(InvoiceRepository invoiceRepository) {
		this.invoiceRepository = invoiceRepository;
	}
	@Override
	public Invoice save(Invoice invoices) {
		Invoice invoice = invoiceRepository.save(invoices);
		if (invoice == null) {
			throw new NotFoundException("Something Went Wrong");
		}
		return invoice;
	}

	@Override
	public List<Invoice> findAllInvoices() {
		List<Invoice> invoiceList = invoiceRepository.findAll();
		if (invoiceList.size() == 0)
			throw new NotFoundException("Currently list is empty !");
		return invoiceList;
	}

	@Override
	public Invoice findInvoiceById(Long invoiceId) {
		Optional<Invoice> result = invoiceRepository.findById(invoiceId);

		Invoice theInvoice = null;
		if (!result.isPresent()) {
			throw new NotFoundException(" Invoice not found !!!, whose id is  " + invoiceId);

		} else {
			theInvoice = result.get();
			return theInvoice;
		}
	}

	@Override
	public String deleteInvoiceById(Long invoiceId) {
		Invoice  theInvoice = findInvoiceById(invoiceId);

		if (theInvoice != null)
			invoiceRepository.delete(theInvoice);
		else
			throw new NotFoundException("Invoice not found!!!");
		return "Invoice with "+invoiceId+"is deleted.";
	}

	@Override
	public List<Invoice> findAllInvoiceByIdInDesc() {
		List<Invoice> sortedByDescInvoice = invoiceRepository.findAllByOrderByInvoiceIdDesc();

		if (sortedByDescInvoice.size() == 0) {
			throw new NotFoundException("Invoice list is empty !!!");
		}
		return sortedByDescInvoice;
	}

	@Override
	public Invoice updateInvoiceById(Long invoiceId, Invoice invoice) {
		Invoice result = findInvoiceById(invoiceId);
		if (result != null) {
			invoiceRepository.save(invoice);
			return invoice;
		} else
			throw new NotFoundException("Invoice  is not available !!!");
	}
	
	@Override
	public Invoice findInvoiceByPaymentId(Long paymentId) {
		Optional<Invoice> result = invoiceRepository.findById(paymentId);

		Invoice theInvoice = null;
		if (!result.isPresent()) {
			throw new NotFoundException(" Invoice not found !!!, whose paymentid is  " + paymentId);

		} else {
			theInvoice = result.get();
			return theInvoice;
		}
	}

}
