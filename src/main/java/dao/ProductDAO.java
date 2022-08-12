package dao;

import model.Product;

import java.util.List;

public interface ProductDAO {
    int save(Product product);

    List<Product> showAll();
}
