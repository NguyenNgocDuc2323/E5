package Entity;

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

    public void setAccount(Account account) {
        this.account = account;
    }

    public void setInvoice(Invoice invoice) {
        this.invoice = invoice;
    }

    @Override
    public String toString() {
        return "Payment{" +
                "account=" + account +
                ", invoice=" + invoice +
                '}';
    }
}
