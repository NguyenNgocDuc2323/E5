package Service;

import Entiy.Account;
import Entiy.Customer;
import Entiy.Invoice;
import Global.Global;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;

public class AccountService {
    private List<Account> accounts;
    private Account account;
    private List<Invoice> invoices;

    public AccountService(List<Account> accounts) {
        this.accounts = accounts;
    }

    public Account getAccount() {
        return account;
    }

    public List<Account> getAccounts() {
        return accounts;
    }

    public Optional<Account> getAccountById(int id) {
        Optional<Account> foundById = accounts.stream()
                .filter(acc -> acc.getId() == id)
                .findFirst();
        if (foundById.isPresent()) {
            return foundById;
        }
        return Optional.empty();
    }

    public List<Account> getAccountByName(String name) {
        List<Account> foundByNameAccs = accounts.stream()
                .filter(acc -> Global.ignoreCase(name, acc.getAccountName()))
                .toList();
        if (foundByNameAccs.isEmpty()) {
            return null;
        }
        return foundByNameAccs;
    }

    public void sortCustomerByAccount() {
        accounts.stream()
                .sorted(Comparator.comparing(account -> account.getBalance()))
                .forEach(System.out::println);
    }




}

