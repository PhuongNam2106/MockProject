package dao;

import model.Product;
import util.DBUtil;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.Timestamp;

public class ProductDAOImpl implements ProductDAO{
    @Override
    public int save(Product product) {
        try(Connection connection = DBUtil.getInstance().getConnection()) {
            java.sql.Date sqlDate ;
            String sql = "INSERT INTO PRODUCT VALUES(?, ?, ?, ?, ?, ?, ?, ?)";
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, product.getName());
            preparedStatement.setString(2, product.getDescription());
            preparedStatement.setDouble(3, product.getPrice());
            preparedStatement.setDouble(4, product.getDiscountPrice());
            preparedStatement.setInt(5, product.getStock());
            preparedStatement.setInt(6, product.getSold());
            preparedStatement.setDate(7,  sqlDate = new java.sql.Date(product.getCreateDate().getTime()));
           // setTimestamp(1, new Timestamp(utilDate.getTime()));
            preparedStatement.setString(8, product.getStatus());

            return preparedStatement.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();

            return 0;
        }
    }
}
