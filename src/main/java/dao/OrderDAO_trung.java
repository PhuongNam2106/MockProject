package dao;

import model.Order;

public interface OrderDAO_trung {
    int save(Order order);
    int customerID();
    double finalTotalOrder(Order order);
}
