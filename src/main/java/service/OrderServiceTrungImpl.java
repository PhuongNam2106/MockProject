package service;

import dao.OrderDAO_trung;
import dao.OrderDAOImpl_trung;
import model.Order;

public class OrderServiceTrungImpl implements OrderService_trung {
    private OrderDAO_trung orderDAOTrung = new OrderDAOImpl_trung();
    @Override
    public boolean createOrder(Order order) {
        return orderDAOTrung.save(order) > 0;
    }
}
