package Controller;

import Entiy.Invoice;
import Service.InvoiceService;

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
        if(cusId < 0){
            return -1;
        }
        return cusId;
    }
    public String getCustomerName(){
        String cusName = is.getCustomerName();
        if(cusName == null){
            return "";
        }
        return cusName;
    }
    public int getCustomerDiscount(){
        int cusDis = is.getCustomerDiscount();
        if(cusDis < 0){
            return -1;
        }
        return cusDis;
    }
    public double getAmountAfterDiscount(){
        double amountAfterDis = is.getAmountAfterDiscount();
        if(amountAfterDis < 0){
            return -1;
        }
        return amountAfterDis;
    }
    public Optional<Invoice> getInvoiceById(int id){
        Optional<Invoice> invoice = is.getInvoiceById(id);
        if(invoice.isPresent()){
            return invoice;
        }
        return Optional.empty();
    }
    public List<Invoice> getInvoiceByAmount(double amount){
        List<Invoice> invoices = is.getInvoiceByAmount(amount);
        if(invoices.isEmpty()){
            return null;
        }
        return invoices;
    }
    public void sortCustomerByInvoice(){
        is.sortCustomerByInvoice();
    }
    public List<Invoice> getDiscount8Month(){
        List<Invoice> discount8Month = is.getDiscount8Month();
        if(discount8Month.isEmpty()){
            return null;
        }
        return discount8Month;
    }
}
