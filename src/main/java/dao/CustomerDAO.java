package dao;

import model.Customer;

import java.util.List;

public interface CustomerDAO {
    int save(Customer customer);

    List<Customer> showAll();
}
