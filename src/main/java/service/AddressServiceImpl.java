package service;

import dao.AddressDAO;
import dao.impl.AddressDAOImpl;
import model.Address;

import java.util.List;

public class AddressServiceImpl implements AddressService{
    private AddressDAO addressDAO = new AddressDAOImpl();
    @Override
    public List<Address> showAll() {
        return addressDAO.showAll();
    }
}
