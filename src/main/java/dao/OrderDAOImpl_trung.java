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
            preparedStatement.setString(2, order.getPhoneNumber());
            preparedStatement.setString(3, order.getDetailAddress());
            preparedStatement.setDouble(4, 0);
            preparedStatement.setDate(5, sqlDate = new java.sql.Date(System.currentTimeMillis()));
            preparedStatement.setInt(6, customerID());
            preparedStatement.setInt(7, order.getAddressID());
            preparedStatement.setInt(8, 1);
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

//TOTAL CHƯA TÍNH SHIP VÀ DISCOUNT
    @Override
    public int saveTotal(Order order) {
        try (Connection connection = DBUtil.getInstance().getConnection()){
            String sql = "UPDATE ORDERS SET TOTAL = (SELECT TOTALSUM FROM TOTAL_SUM TS WHERE TS.ORDER_ID = ORDERS.ORDER_ID)";
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            return preparedStatement.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
            return 0;
        }
    }
//TOTAL SAU KHI TINH SHIP VA DISCOUNT
    @Override
    public int finalTotal(Order order) {
        try (Connection connection = DBUtil.getInstance().getConnection()){
            String sql = "UPDATE ORDERS SET TOTAL = (SELECT TOTALFINAL FROM TOTALFINAL TF WHERE TF.ORDER_ID = ORDERS.ORDER_ID)";
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            return preparedStatement.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
            return 0;
        }
    }

    @Override
    public int updateDiscount(Order order) {
        try (Connection connection = DBUtil.getInstance().getConnection()){
            String sql = "UPDATE ORDERS SET DISCOUNT_ID = (SELECT DISCOUNT_ID FROM DISCOUNT WHERE ORDERS.ORDER_DATE >= DISCOUNT.START_DATE AND ORDERS.ORDER_DATE <= DISCOUNT.END_DATE  )";
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            return preparedStatement.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
            return 0;
        }
    }

}
