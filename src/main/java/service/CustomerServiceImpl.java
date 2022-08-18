package service;

import dao.CustomerDAO;
import dao.CustomerDAOImpl;
import model.Customer;
import view.Menu;

import java.util.List;

public class CustomerServiceImpl implements CustomerService{
    private CustomerDAO customerDAO = new CustomerDAOImpl();
    @Override
    public boolean createCustomer(Customer customer) {

        return customerDAO.save(customer) > 0;
    }

    @Override
    public List<Customer> showAll() {
        return customerDAO.showAll();
    }
}
