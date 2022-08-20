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

    @Override
    public boolean saveTotal(Order order) {
        return orderDAOTrung.saveTotal(order) > 0;
    }

    @Override
    public boolean updateDiscount(Order order) {
        return orderDAOTrung.updateDiscount(order) > 0;
    }

    @Override
    public boolean updateTotalFinal(Order order) {
        return orderDAOTrung.finalTotal(order) > 0;
    }
}
