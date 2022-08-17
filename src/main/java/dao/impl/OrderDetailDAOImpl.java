package dao.impl;

import dao.OrderDetailDAO;
import model.OrderDetail;
import util.DBUtil;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class OrderDetailDAOImpl implements OrderDetailDAO {
    @Override
    public List<OrderDetail> showOrderDetail(int id) {
        try (Connection connection = DBUtil.getInstance().getConnection()) {
            String sql = "SELECT * FROM ORDER_DETAIL INNER JOIN ORDERS ON ORDER_DETAIL.ORDER_ID=  ORDERS.ORDER_ID WHERE ORDERS.ORDER_ID =" +(id+1);

            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(sql);

            List<OrderDetail> orderDetails = new ArrayList<>();
            while (resultSet.next()) {
                int cartID = resultSet.getInt("CART_ID");
                int quantity = resultSet.getInt("QUANTITY");
                double total = resultSet.getDouble("TOTAL");
                int product_id = resultSet.getInt("PRODUCT_ID");
                orderDetails.add(new OrderDetail(cartID,quantity,total,product_id));
            }

            return orderDetails;
        } catch (Exception e) {
            e.printStackTrace();

            return new ArrayList<>();
        }
    }
}
