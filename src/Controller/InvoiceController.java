package Controller;

import Entity.Invoice;
import Service.InvoiceService;

import java.util.Comparator;
import java.util.List;
import java.util.Optional;

public class InvoiceController {
    private List<Invoice> invoices;
    private Invoice invoice;
    private InvoiceService is;
    public InvoiceController(InvoiceService is) {
        this.is = is;
        this.invoice = is.getInvoice();
        this.invoices = is.getInvoices();
    }
    public int getCustomerId(){
        int cusId = is.getCustomerId();
        return cusId < 0 ? -1 : cusId;
    }
    public String getCustomerName(){
        String cusName = is.getCustomerName();
        return cusName == null ? "" : cusName;
    }
    public int getCustomerDiscount(){
        int cusDis = is.getCustomerDiscount();
        return cusDis < 0 ? -1 : cusDis;
    }
    public double getAmountAfterDiscount(){
        double amountAfterDis = is.getAmountAfterDiscount();
        return amountAfterDis < 0 ? -1 : amountAfterDis;
    }
    public Invoice getInvoiceById(int id){
        Invoice invoice = is.getInvoiceById(id);
        return invoice == null ? null : invoice;
    }
    public List<Invoice> getInvoiceByAmount(double amount){
        List<Invoice> invoices = is.getInvoiceByAmount(amount);
        return invoices.size() > 0 ? invoices : null;
    }
    public void sortCustomerByInvoice(){
        invoices.stream()
                .sorted(Comparator.comparing(invoice -> invoice.getAmount()))
                .forEach(System.out::println);
    }
    public List<Invoice> getDiscount8Month(){
        List<Invoice> discount8Month = is.getDiscount8Month();
        return discount8Month.size() > 0 ? discount8Month : null;
    }
}
