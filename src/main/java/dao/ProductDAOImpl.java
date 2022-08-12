package dao;

import model.Product;
import util.DBUtil;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

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

    @Override
    public List<Product> showAll() {
        try (Connection connection = DBUtil.getInstance().getConnection()) {
            String sql = "SELECT * FROM PRODUCT";

            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(sql);

            List<Product> products = new ArrayList<>();
            while (resultSet.next()) {
                int id = resultSet.getInt("PRODUCT_ID");
                String name = resultSet.getString("NAME");
                String description = resultSet.getString("DESCRIPTION");
                double price = resultSet.getDouble("PRICE");
                double discountPrice = resultSet.getDouble("DISCOUNT_PRICE");
                int stock = resultSet.getInt("STOCK");
                int sold = resultSet.getInt("SOLD");
                Date createdDate = resultSet.getDate("CREATE_DATE");
                String status = resultSet.getString("STATUS");


                products.add(new Product(id, name, description,price,discountPrice,stock,sold,createdDate,status));
            }

            return products;
        } catch (Exception e) {
            e.printStackTrace();

            return new ArrayList<>();
        }
    }


}
