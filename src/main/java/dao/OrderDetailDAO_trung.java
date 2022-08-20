package dao;

import model.OrderDetail;
import model.Product;

public interface OrderDetailDAO_trung {
    int save(OrderDetail orderDetail);
    int orderID();
    double productPriceFinal(OrderDetail orderDetail);
    int updateStock(Product product);
    int updateSold(Product product);
}
