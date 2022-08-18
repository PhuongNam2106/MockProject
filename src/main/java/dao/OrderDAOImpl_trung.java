package dao;

import model.Order;
import util.DBUtil;

import java.sql.*;

public class OrderDAOImpl_trung implements OrderDAO_trung {
    @Override
    public int save(Order order) {
        try (Connection connection = DBUtil.getInstance().getConnection()){
            java.sql.Date sqlDate ;
            String sql = "INSERT INTO ORDERS VALUES(?, ?, ?, ?, ?, ?, ?, ?)";
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, order.getName());
            preparedStatement.setInt(2, order.getPhoneNumber());
            preparedStatement.setString(3, order.getDetailAddress());
            preparedStatement.setDouble(4, finalTotalOrder(order));
            preparedStatement.setDate(5, sqlDate = new java.sql.Date(order.getOrderDate().getTime()));
            preparedStatement.setInt(6, customerID());
            preparedStatement.setInt(7, order.getAddressID());
            preparedStatement.setInt(8, order.getDiscountId());
            return preparedStatement.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();

            return 0;
        }
    }

    @Override
    public int customerID() {

        try(Connection connection = DBUtil.getInstance().getConnection()){
            int ketqua = 0;
            String cusID = "SELECT TOP 1 CUSTOMER_ID FROM CUSTOMERS ORDER BY CUSTOMER_ID DESC";
            Statement statement = connection.createStatement();
            ResultSet rs = statement.executeQuery(cusID);
            while(rs.next()){
                ketqua = rs.getInt(1);
            }
            return ketqua;
        }catch (Exception e) {
            e.printStackTrace();
            return 0;
        }
    }

    @Override
    public double finalTotalOrder(Order order) {
        try(Connection connection = DBUtil.getInstance().getConnection()){
            double ketqua = 0;
            String productPriceFinal = "SELECT SUM(TOTAL) FROM ORDER_DETAIL GROUP BY ORDER_ID ";
            PreparedStatement preparedStatement = connection.prepareStatement(productPriceFinal);
            ResultSet rs  = preparedStatement.executeQuery();
            while(rs.next()){
                ketqua = rs.getInt(1);
            }
            return ketqua;
        }catch (Exception e) {
            e.printStackTrace();
            return 0;
        }
    }
}
