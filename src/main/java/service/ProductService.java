package service;

import model.Product;

import java.util.List;

public interface ProductService {
    boolean save(Product product);

    List<Product> showAll();
}
