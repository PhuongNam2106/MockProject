package dao.impl;

import dao.OrderDAO;
import model.Order;
import util.DBUtil;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class OrderDAOImpl implements OrderDAO {
    @Override
    public List<Order> showAll() {
        try (Connection connection = DBUtil.getInstance().getConnection()) {
            String sql = "SELECT O.* , C.FULL_NAME FROM ORDERS O JOIN CUSTOMERS C ON C.CUSTOMER_ID = O.CUSTOMER_ID";

            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(sql);

            List<Order> orders = new ArrayList<>();
            while (resultSet.next()) {
                int id = resultSet.getInt("ORDER_ID");
                String name = resultSet.getString("NAME");
                String phone = resultSet.getString("PHONE_NUMBER");
                String address = resultSet.getString("DETAIL_ADDRESS");
                double total = resultSet.getDouble("TOTAL");
                Date orderDate = resultSet.getDate("ORDER_DATE");
                int customer_id = resultSet.getInt("CUSTOMER_ID");
                String fullName = resultSet.getString("FULL_NAME");
                int address_id = resultSet.getInt("ADDRESS_ID");
                int discount_id = resultSet.getInt("DISCOUNT_ID");
                orders.add(new Order(id,name,phone,address,total,orderDate,customer_id,fullName,address_id,discount_id));
            }

            return orders;
        } catch (Exception e) {
            e.printStackTrace();

            return new ArrayList<>();
        }
    }
}
