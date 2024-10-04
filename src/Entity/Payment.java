package Entiy;

public class Payment {
    private Account account;
    private Invoice invoice;

    public Payment(Account account, Invoice invoice) {
        this.account = account;
        this.invoice = invoice;
    }

    public Account getAccount() {
        return account;
    }

    public Invoice getInvoice() {
        return invoice;
    }
}
