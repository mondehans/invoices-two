package net.monde.invoices.data;


import javax.persistence.*;
import javax.validation.Valid;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "invoices")
public class Invoice implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull
    @NotEmpty
    private String client;

    @NotNull
    private Long vatRate;

    @NotNull
    private Date invoiceDate;

    @NotEmpty
    @Valid
    @OneToMany(
            cascade = CascadeType.ALL,
            orphanRemoval = true
    )
    @JoinColumn(name = "invoice_id")
    private List<LineItem> lineItems;

    public Long getId() {
        return id;
    }

    public String getClient() {
        return client;
    }

    public void setClient(String client) {
        this.client = client;
    }

    public Long getVatRate() {
        return vatRate;
    }

    public void setVatRate(Long vatRate) {
        this.vatRate = vatRate;
    }

    public Date getInvoiceDate() {
        return invoiceDate;
    }

    public void setInvoiceDate(Date invoiceDate) {
        this.invoiceDate = invoiceDate;
    }

    public List<LineItem> getLineItems() {
        return lineItems;
    }

    public void setLineItems(List<LineItem> lineItems) {
        this.lineItems = lineItems;
    }


    public BigDecimal getSubTotal(){
       return lineItems.stream().map(x -> x.getUnitPrice().multiply(new BigDecimal(x.getQuantity()))).reduce(BigDecimal::add).get();
    }

    public BigDecimal getVat(){

      return  lineItems.stream().map(x -> x.getUnitPrice().multiply(new BigDecimal(x.getQuantity()))).reduce(BigDecimal::add).get().multiply(new BigDecimal(getVatRate()).divide(new BigDecimal(100l)));
    }

    public BigDecimal getTotal(){
        return getSubTotal().add(getVat());
    }

    @Override
    public String toString() {
        return "Invoice{" +
                "id=" + id +
                ", client='" + client + '\'' +
                ", vatRate=" + vatRate +
                ", invoiceDate=" + invoiceDate +
                ", lineItems=" + lineItems +
                '}';
    }
}