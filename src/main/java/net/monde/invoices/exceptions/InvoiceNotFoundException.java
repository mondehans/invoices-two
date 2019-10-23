package net.monde.invoices.exceptions;

public class InvoiceNotFoundException extends RuntimeException{

    public InvoiceNotFoundException(String message) {
        super(message);
    }
}
