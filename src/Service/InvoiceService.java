package Service;

import Entiy.Customer;
import Entiy.Gender;
import Entiy.Invoice;

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
    public Optional<Invoice> getInvoiceById(int id) {
        Optional<Invoice> foundByIdInvoice =  invoices.stream()
                .filter(invoice -> invoice.getId() == id)
                .findFirst();
        if(foundByIdInvoice.isPresent()){
            return foundByIdInvoice;
        }
        else{
            return Optional.empty();
        }
    }
    public List<Invoice> getInvoiceByAmount(double amount) {
        List<Invoice> foundByAmountInvoices =  invoices.stream()
                .filter(invoice -> invoice.getAmount() == amount)
                .toList();
        if(foundByAmountInvoices.isEmpty()){
            return null;
        }
        else{
            return foundByAmountInvoices;
        }
    }
    public void sortCustomerByInvoice(){
        invoices.stream()
                .sorted(Comparator.comparing(invoice -> invoice.getAmount()))
                .forEach(System.out::println);
    }
    public List<Invoice> getDiscount8Month() {
        List<Invoice> discount8MonthInvoices = new ArrayList<>();
        List<Invoice> eightMonthInvoices = invoices.stream()
                .filter(invoice -> invoice.getDateTime().getMonthValue() == 8)
                .toList();
        eightMonthInvoices.forEach(invoice -> {
            if (invoice.getCustomer().getGender() == Gender.F) {
                invoice.getCustomer().setDiscount(invoice.getCustomer().getDiscount() + 10);
                discount8MonthInvoices.add(invoice);
            }
        });
        return discount8MonthInvoices;
    }

}
