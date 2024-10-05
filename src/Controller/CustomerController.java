package Controller;

import Entity.Customer;
import Service.CustomerService;

import java.util.Comparator;
import java.util.List;

public class CustomerController {
    private List<Customer> customers;
    private CustomerService cs;
    public CustomerController(CustomerService cs) {
        this.cs = cs;
        this.customers = cs.getCustomers();
    }
    public void sortCustomerByName() {
        customers.stream()
                .sorted(Comparator.comparing(Customer::getName))
                .forEach(System.out::println);
    }
}
