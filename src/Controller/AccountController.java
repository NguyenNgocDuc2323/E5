package Controller;

import Entiy.Account;
import Entiy.Customer;
import Entiy.Invoice;
import Entiy.Payment;
import Service.AccountService;
import Service.InvoiceService;

import java.util.ArrayList;
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

    public Account withdraw(double amount) {
        if(account.getBalance() >= amount) {
            account.setBalance(account.getBalance() - amount);
        }
        return account;
    }
    public Optional<Account> getAccountById(int id){
        Optional<Account> foundAcc = as.getAccountById(id);
        if(foundAcc.isPresent()){
            return foundAcc;
        }
        else{
            return Optional.empty();
        }
    }
    public List<Account> getAccountByName(String name){
        List<Account> foundAccs = as.getAccountByName(name);
        if(foundAccs.isEmpty()){
            return null;
        }
        else{
            return foundAccs;
        }
    }
    public void sortCustomerByAccount(){
        as.sortCustomerByAccount();
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
}
