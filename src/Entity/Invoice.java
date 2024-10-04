package Entiy;
import java.time.LocalDate;
public class Invoice extends Customer{
    private int id;
    private double amount;
    Customer customer;
    private LocalDate dateTime;
    public Invoice() {}

    public Invoice(int id, double amount, Customer customer, LocalDate dateTime) {
        this.id = id;
        this.amount = amount;
        this.customer = customer;
        this.dateTime = dateTime;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public LocalDate getDateTime() {
        return dateTime;
    }

    public void setDateTime(LocalDate dateTime) {
        this.dateTime = dateTime;
    }

    @Override
    public String toString() {
        return "Invoice{" +
                "id=" + id +
                ", amount=" + amount +
                ", customer=" + customer +
                ", dateTime=" + dateTime +
                '}';
    }
}
