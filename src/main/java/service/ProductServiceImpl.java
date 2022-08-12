package service;

import dao.ProductDAO;
import dao.ProductDAOImpl;
import model.Product;

import java.util.List;

public class ProductServiceImpl implements ProductService{
    private ProductDAO productDAO = new ProductDAOImpl();
    @Override
    public boolean save(Product product) {

        return productDAO.save(product) > 0;
    }

    @Override
    public List<Product> showAll() {
        return productDAO.showAll();
    }
}
