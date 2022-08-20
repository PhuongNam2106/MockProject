package dao;

import model.Order;

public interface OrderDAO_trung {
    int save(Order order);
    int customerID();
    int saveTotal(Order order);
    int finalTotal(Order order);
    int updateDiscount(Order order);
}
