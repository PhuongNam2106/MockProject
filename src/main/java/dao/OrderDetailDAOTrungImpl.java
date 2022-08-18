package dao;

import model.OrderDetail;
import util.DBUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

public class OrderDetailDAOTrungImpl implements OrderDetailDAO_trung {
    @Override
    public int save(OrderDetail orderDetail) {
        try (Connection connection = DBUtil.getInstance().getConnection()){
            java.sql.Date sqlDate ;
            String sql = "INSERT INTO ORDER_DETAIL VALUES(?, ?, ?, ?)";
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1, orderDetail.getQuantity());
            preparedStatement.setDouble(2, productPriceFinal(orderDetail)*orderDetail.getQuantity());
            preparedStatement.setInt(3, orderID());
            preparedStatement.setInt(4, orderDetail.getProductId());
            return preparedStatement.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();

            return 0;
        }
    }

    @Override
    public int orderID() {
        try(Connection connection = DBUtil.getInstance().getConnection()){
            int ketqua = 0;
            String oderID = "SELECT TOP 1 ORDER_ID FROM ORDERS ORDER BY ORDER_ID DESC";
            Statement statement = connection.createStatement();
            ResultSet rs = statement.executeQuery(oderID);
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
    public double productPriceFinal(OrderDetail orderDetail) {
        try(Connection connection = DBUtil.getInstance().getConnection()){
            double ketqua = 0;
            String productPriceFinal = "SELECT PRICE - DISCOUNT_PRICE FROM PRODUCT WHERE PRODUCT_ID =?";
            PreparedStatement preparedStatement = connection.prepareStatement(productPriceFinal);
            preparedStatement.setInt(1, orderDetail.getProductId());
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
