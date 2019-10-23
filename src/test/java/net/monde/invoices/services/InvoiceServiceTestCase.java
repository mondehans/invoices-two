package net.monde.invoices.services;


import net.monde.invoices.data.Invoice;
import net.monde.invoices.repository.InvoiceRepository;
import net.monde.invoices.services.impl.InvoiceServiceImpl;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;
import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

@SpringBootTest
public class InvoiceServiceTestCase {

    @Mock
    InvoiceRepository invoiceRepository;

    @InjectMocks
    InvoiceServiceImpl service = new InvoiceServiceImpl();


    @BeforeEach
    public void setUp(){
        List results= new ArrayList<>();
        results.add(new Invoice());
        when(invoiceRepository.findAll()).thenReturn(results);
        when(invoiceRepository.findById(any())).thenReturn(Optional.of(new Invoice()));
    }

    @Test
    public void shouldNotBeNull(){
        Optional<List<Invoice>> invoices = service.viewAllInvoices();

        assertEquals(true,invoices.isPresent());
    }

    @Test
    public void shouldFindById(){
        Optional<Invoice> invoice = service.viewInvoice(1l);
        assertNotNull(invoice.get());
    }
}
