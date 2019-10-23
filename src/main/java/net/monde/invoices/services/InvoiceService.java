package net.monde.invoices.services;

import net.monde.invoices.data.Invoice;

import java.util.List;
import java.util.Optional;

public interface InvoiceService {

    Optional<Invoice> viewInvoice(Long id);
    Optional<List<Invoice>> viewAllInvoices();
    Invoice addInvoice(Invoice invoice);
}
