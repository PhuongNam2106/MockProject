package dao;

import model.OrderDetail;

import java.util.List;

public interface OrderDetailDAO {
    List<OrderDetail> showOrderDetail(int id);
}
