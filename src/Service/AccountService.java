package Service;

import Entity.Account;
import Entity.Invoice;
import Global.Global;

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

    public Account getAccountById(int id) {
        Optional<Account> foundById = accounts.stream()
                .filter(acc -> acc.getId() == id)
                .findFirst();
        return foundById.isPresent() ? foundById.get() : null;
    }

    public List<Account> getAccountByName(String name) {
        List<Account> foundByNameAccs = accounts.stream()
                .filter(acc -> Global.ignoreCase(name, acc.getAccountName()))
                .toList();
        return foundByNameAccs.size() > 0 ? foundByNameAccs : null;
    }
}

