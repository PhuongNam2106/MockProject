package dao;

import model.Customer;
import util.DBUtil;
import view.Menu;

import java.sql.Connection;
import java.sql.PreparedStatement;

public class CustomerDAOImpl implements CustomerDAO{
    @Override
    public int save(Customer customer) {

        try(Connection connection = DBUtil.getInstance().getConnection()){
            String sql = "INSERT INTO CUSTOMERS VALUES (?, ?, ?, ?)";
//            System.out.println("Customer information:");
//            customer = Menu.getInstance().customerMenu();
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, customer.getFullName());
            preparedStatement.setString(2, customer.getEmail());
            preparedStatement.setString(3, customer.getPhoneNumber());
            preparedStatement.setInt(4, customer.getAddressId());
            return preparedStatement.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();

            return 0;
        }
    }
}
