package Controller;

import Entity.Account;
import Entity.Customer;
import Entity.Invoice;
import Entity.Payment;
import Service.AccountService;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;

public class AccountController {
    private List<Account> accounts;
    private Account account;
    private AccountService as;
    public List<Invoice> invoices;
    public AccountController(AccountService as, List<Invoice> invoices) {
        this.as = as;
        this.accounts = as.getAccounts();
        this.account = as.getAccount();
        this.invoices = invoices;
    }
    public String getCustomerName(Customer customer) {
        return customer.getName();
    }
    public Account deposit(double amount) {
        account.setBalance(account.getBalance() + amount);
        return account;
    }

    public void withdraw(double amount) {
        if(account.getBalance() >= amount) {
            account.setBalance(account.getBalance() - amount);
        }
        else{
            System.out.println("Tài Khoản Của Quý khách không đủ số dư");
        }
    }
    public Account getAccountById(int id){
        Account foundAcc = as.getAccountById(id);
        return foundAcc == null ? null : foundAcc;
    }
    public List<Account> getAccountByName(String name){
        List<Account> foundAccs = as.getAccountByName(name);
        return foundAccs.size() > 0 ? foundAccs : null;
    }
    public List<Payment> checkCanAccPay() {
        List<Payment> canPayDetails = new ArrayList<>();
        accounts.stream().forEach(account -> {
            double discount = account.getCustomer().getDiscount();
            double balance = account.getBalance();
            invoices.stream().forEach(invoice -> {
                double amount = invoice.getAmount();
                double discountedAmount = amount - (discount * amount / 100);
                if (balance >= discountedAmount) {
                    canPayDetails.add(new Payment(account, invoice));
                }
            });
        });

        return canPayDetails;
    }
    public List<Payment> checkCannotAccPay() {
        List<Payment> cannotPayDetails = new ArrayList<>();
        accounts.stream().forEach(account -> {
            double balance = account.getBalance();
            invoices.stream().forEach(invoice -> {
                double amount = invoice.getAmount();
                if (balance < amount) {
                    cannotPayDetails.add(new Payment(account, invoice));
                }
            });
        });

        return cannotPayDetails;
    }
    public void sortCustomerByAccount() {
        accounts.stream()
                .sorted(Comparator.comparing(account -> account.getBalance()))
                .forEach(System.out::println);
    }
}
