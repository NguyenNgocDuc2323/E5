package Controller;

import Entiy.Customer;
import Service.CustomerService;

import java.util.List;

public class CustomerController {
    private List<Customer> customers;
    private CustomerService cs;
    public CustomerController(CustomerService cs) {
        this.cs = cs;
        this.customers = cs.getCustomers();
    }
    public void sortCustomerByName(){
        cs.sortCustomerByName();
    }
}
