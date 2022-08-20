package service;

import model.Order;

public interface OrderService_trung {
    boolean createOrder(Order order);
    boolean saveTotal(Order order);
    boolean updateDiscount(Order order);
    boolean updateTotalFinal(Order order);
}
