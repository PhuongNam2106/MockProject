package service;

import model.Customer;

import java.util.List;

public interface CustomerService {
    boolean createCustomer(Customer customer);

    List<Customer> showAll();
}
