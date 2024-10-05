package Entity;

public class Account extends Customer{
    private int id;
    Customer customer;
    private double balance = 0.0;
    private String accountName;
    public Account() {}
    public Account(int id, Customer customer) {
        this.id = id;
        this.customer = customer;
    }
    public Account(int id, Customer customer, double balance,String accountName) {
        this.id = id;
        this.customer = customer;
        this.balance = balance;
        this.accountName = accountName;
    }

    public String getAccountName() {
        return accountName;
    }

    public void setAccountName(String accountName) {
        this.accountName = accountName;
    }

    @Override
    public int getId() {
        return id;
    }

    @Override
    public void setID(int id) {
        this.id = id;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    @Override
    public String toString() {
        return "Account{" +
                "id=" + id +
                ", customer=" + customer +
                ", balance=" + String.format("%.2f", balance) +
                ", accountName='" + accountName + '\'' +
                '}';
    }

}
