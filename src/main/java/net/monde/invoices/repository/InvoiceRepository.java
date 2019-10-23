package net.monde.invoices.repository;

import net.monde.invoices.data.Invoice;
import org.springframework.data.repository.CrudRepository;

public interface InvoiceRepository extends CrudRepository<Invoice, Long> {
}
