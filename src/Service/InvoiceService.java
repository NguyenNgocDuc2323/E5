package Service;

import Entity.Gender;
import Entity.Invoice;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;

public class InvoiceService {
    private List<Invoice> invoices;
    private Invoice invoice;
    public InvoiceService(List<Invoice> invoices) {
        this.invoices = invoices;
    }
    public List<Invoice> getInvoices() {
        return invoices;
    }
    public Invoice getInvoice() {
        return invoice;
    }
    public int getCustomerId() {
        int cusId = invoice.getCustomer().getId();
        return cusId;
    }
    public String getCustomerName() {
        String cusName = invoice.getCustomer().getName();
        return cusName;
    }
    public int getCustomerDiscount(){
        int dis = invoice.getCustomer().getDiscount();
        return dis;
    }
    public double getAmountAfterDiscount(){
        double amount = invoice.getAmount();
        int dis = getCustomerDiscount();
        return amount - (amount * dis);
    }
    public Invoice getInvoiceById(int id) {
        Optional<Invoice> foundByIdInvoice =  invoices.stream()
                .filter(invoice -> invoice.getId() == id)
                .findFirst();
        return foundByIdInvoice.isPresent() ? foundByIdInvoice.get() : null;
    }
    public List<Invoice> getInvoiceByAmount(double amount) {
        List<Invoice> foundByAmountInvoices =  invoices.stream()
                .filter(invoice -> invoice.getAmount() == amount)
                .toList();
        return foundByAmountInvoices.size() > 0 ? foundByAmountInvoices : null;
    }
    public List<Invoice> getDiscount8Month() {
        List<Invoice> eightMonthInvoices = invoices.stream()
                .filter(invoice -> invoice.getDateTime().getMonthValue() == 8 && invoice.getCustomer().getGender() == Gender.F)
                .toList();
        return eightMonthInvoices.size() > 0 ? eightMonthInvoices : null;
    }
}
