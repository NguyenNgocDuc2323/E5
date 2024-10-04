package Service;

import Entiy.Customer;

import java.util.Comparator;
import java.util.List;

public class CustomerService {
    private Customer customer;
    private List<Customer> customers;
    public CustomerService(List<Customer> customers) {
        this.customers = customers;
    }
    public Customer getCustomer() {
        return customer;
    }
    public List<Customer> getCustomers() {
        return customers;
    }
    public void sortCustomerByName() {
        customers.stream()
                .sorted(Comparator.comparing(Customer::getName))
                .forEach(System.out::println);
    }

}
