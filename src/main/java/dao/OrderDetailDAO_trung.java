package dao;

import model.OrderDetail;

public interface OrderDetailDAO_trung {
    int save(OrderDetail orderDetail);
    int orderID();
    double productPriceFinal(OrderDetail orderDetail);
}
