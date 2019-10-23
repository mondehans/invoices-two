package net.monde.invoices.services.impl;


import net.monde.invoices.data.Invoice;

import net.monde.invoices.repository.InvoiceRepository;
import net.monde.invoices.services.InvoiceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.validation.Valid;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class InvoiceServiceImpl implements InvoiceService {

    @Autowired
    InvoiceRepository invoiceRepository;

    @Override
    public Optional<Invoice> viewInvoice(Long id) {
        return invoiceRepository.findById(id);
    }

    @Override
    public Optional<List<Invoice>> viewAllInvoices() {

        List<Invoice> invoices = new ArrayList<>();
        Iterable<Invoice> iterable = invoiceRepository.findAll();
        iterable.forEach(invoices::add);
        return invoices.size()>0?Optional.of(invoices):Optional.empty();
    }

    @Override
    public Invoice addInvoice(Invoice invoice) {

        return invoiceRepository.save(invoice);
    }
}
