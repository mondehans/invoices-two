package net.monde.invoices.net.monde.invoices.rest;


import net.monde.invoices.data.Invoice;
import net.monde.invoices.exceptions.InvoiceNotFoundException;
import net.monde.invoices.services.InvoiceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class InvoicesController {

    @Autowired
    private InvoiceService invoiceService;

    @GetMapping("/invoices/{id}")
    public Invoice viewInvoice(@PathVariable Long id){
        return invoiceService.viewInvoice(id).orElseThrow(() ->new InvoiceNotFoundException("not found") );
    }

    @GetMapping("/invoices")
    public List<Invoice> viewAllInvoices(){
        return invoiceService.viewAllInvoices().orElseThrow(() ->new InvoiceNotFoundException("not found"));
    }

    @PostMapping("/invoices")
    public Invoice addInvoice(@Validated @RequestBody Invoice body){
        return invoiceService.addInvoice(body);
    }
}
