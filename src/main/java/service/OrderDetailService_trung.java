package service;

import model.OrderDetail;
import model.Product;

public interface OrderDetailService_trung {
    boolean createOrderService(OrderDetail orderDetail);
    boolean updateStock(Product product);
    boolean updateSold(Product product);
}
