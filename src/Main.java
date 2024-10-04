import Controller.AccountController;
import Controller.CustomerController;
import Controller.InvoiceController;
import Entiy.*;
import Service.AccountService;
import Service.CustomerService;
import Service.InvoiceService;

import java.time.LocalDate;
import java.util.*;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        List<Customer> customers = new ArrayList<Customer>();
        List<Account> accounts = new ArrayList<Account>();
        List<Invoice> invoices = new ArrayList<Invoice>();
//        A
        customers.add(new Customer(1,"Nguyen Ngoc Duc", Gender.M,5));
        customers.add(new Customer(2,"Nguyen Thi Phuong",Gender.F,10));
        customers.add(new Customer(3,"Le Thi Dau",Gender.F,15));

        accounts.add(new Account(1,customers.get(0),1000,"Nguyen Ngoc Duc"));
        accounts.add(new Account(2,customers.get(1),1500,"Nguyen Thi Phuong"));
        accounts.add(new Account(3,customers.get(2),2000,"Le Thi Dau"));

        invoices.add(new Invoice(1,100,customers.get(0), LocalDate.of(2024,6,20)));
        invoices.add(new Invoice(2,1500,customers.get(1), LocalDate.of(2024,8,12)));
        invoices.add(new Invoice(3,2000,customers.get(2), LocalDate.of(2024,8,5)));

        AccountService as = new AccountService(accounts);
        InvoiceService is = new InvoiceService(invoices);
        CustomerService cs = new CustomerService(customers);
        AccountController ac = new AccountController(as,invoices);
        InvoiceController iv = new InvoiceController(is);
        CustomerController ct = new CustomerController(cs);
//        B
        Scanner scanner= new Scanner(System.in);
        System.out.println("Sort Customer By Name : ");
        ct.sortCustomerByName();
        System.out.println("Sort Customer By Account : ");
        ac.sortCustomerByAccount();
        System.out.println("Sort Customer By Invoice : ");
        iv.sortCustomerByInvoice();
//        C
        System.out.print("\nInput Account ID : ");
        int accountId = scanner.nextInt();
        Optional<Account> foundAccById =  ac.getAccountById(accountId);
        System.out.println(foundAccById);
        scanner.nextLine();
        System.out.print("\nInput Account Name : ");
        String accountName = scanner.nextLine();
        List<Account> getAccByNames = ac.getAccountByName(accountName);
        getAccByNames.forEach(System.out::println);

        System.out.print("\nInput Invoice ID : ");
        int invoiceId = scanner.nextInt();
        Optional<Invoice> getInvoiceById = iv.getInvoiceById(invoiceId);
        System.out.println(getInvoiceById);
        scanner.nextLine();
        System.out.print("\nInput Invoice Amount : ");
        double invoiceAmount = scanner.nextDouble();
        List<Invoice> getInvoiceByAmount = iv.getInvoiceByAmount(invoiceAmount);
        getInvoiceByAmount.forEach(System.out::println);

//        D:
        System.out.println("\n Câu D : ");
        List<Payment> canPayAccs = ac.checkCanAccPay();
        canPayAccs.forEach(acc -> {
            System.out.println("Tài khoản " + acc.getAccount().getId() +
                    " có thể thanh toán đơn hàng: " + acc.getInvoice().getId());
        });

//         E:
        System.out.println("\n Câu E : ");
        List<Payment> cannotPayAccs = ac.checkCannotAccPay();
        cannotPayAccs.forEach(acc -> {
            System.out.println("Tài khoản " + acc.getAccount().getId() +
                    " không thể thanh toán đơn hàng: " + acc.getInvoice().getId());
        });
        System.out.println("\n Câu F : ");
        List<Invoice> discount8Months = iv.getDiscount8Month();
        discount8Months.forEach(acc -> {
            System.out.println(acc);
        });

    }
}