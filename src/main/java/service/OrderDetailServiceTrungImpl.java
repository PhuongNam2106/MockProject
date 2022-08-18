package service;

import dao.OrderDetailDAO_trung;
import dao.OrderDetailDAOTrungImpl;
import model.OrderDetail;

public class OrderDetailServiceTrungImpl implements OrderDetailService_trung {
    @Override
    public boolean createOrderService(OrderDetail orderDetail) {
        OrderDetailDAO_trung orderDetailDAOTrung = new OrderDetailDAOTrungImpl();
        return orderDetailDAOTrung.save(orderDetail) > 0;
    }
}
