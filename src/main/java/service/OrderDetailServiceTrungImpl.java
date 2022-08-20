package service;

import dao.OrderDetailDAO_trung;
import dao.OrderDetailDAOTrungImpl;
import model.OrderDetail;
import model.Product;

public class OrderDetailServiceTrungImpl implements OrderDetailService_trung {
    private OrderDetailDAO_trung orderDetailDAOTrung = new OrderDetailDAOTrungImpl();
    @Override
    public boolean createOrderService(OrderDetail orderDetail) {

        return orderDetailDAOTrung.save(orderDetail) > 0;
    }

    @Override
    public boolean updateStock(Product product) {
        return orderDetailDAOTrung.updateStock(product) > 0;
    }

    @Override
    public boolean updateSold(Product product) {
        return orderDetailDAOTrung.updateSold(product) > 0;
    }
}
