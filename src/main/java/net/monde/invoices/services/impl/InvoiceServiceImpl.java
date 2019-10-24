package net.monde.invoices.services.impl;


import net.monde.invoices.data.Invoice;

import net.monde.invoices.repository.InvoiceRepository;
import net.monde.invoices.services.InvoiceService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.validation.Valid;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class InvoiceServiceImpl implements InvoiceService {

    private static final Logger logger = LoggerFactory.getLogger(InvoiceServiceImpl.class);

    @Autowired
    InvoiceRepository invoiceRepository;

    @Override
    public Optional<Invoice> viewInvoice(Long id) {
        logger.debug("view an invoice");
        return invoiceRepository.findById(id);
    }

    @Override
    public Optional<List<Invoice>> viewAllInvoices() {
        logger.debug("viewing all invoices");
        List<Invoice> invoices = new ArrayList<>();
        Iterable<Invoice> iterable = invoiceRepository.findAll();
        iterable.forEach(invoices::add);
        return invoices.size()>0?Optional.of(invoices):Optional.empty();
    }

    @Override
    public Invoice addInvoice(Invoice invoice) {
        logger.debug("Adding a new invoice");
        return invoiceRepository.save(invoice);
    }
}
