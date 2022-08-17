package service.impl;

import dao.OrderDAO;
import dao.OrderDetailDAO;
import dao.impl.OrderDAOImpl;
import dao.impl.OrderDetailDAOImpl;
import model.Order;
import model.OrderDetail;
import service.OrderService;

import java.util.List;
import java.util.Scanner;

public class OrderServiceImpl implements OrderService {
    private OrderDAO orderDAO = new OrderDAOImpl();
    private OrderDetailDAO orderDetailDAO = new OrderDetailDAOImpl();
    @Override
    public void showOrder() {
        List<Order> list = orderDAO.showAll();
        if (list.size() == 0) {
            System.out.println("No list yet");
        } else {
            for (int i = 0; i < list.size(); i++) {
                System.out.println(i + " " + list.get(i).toString());
            }

            showOrderDetail(list);
        }
    }
    private void showOrderDetail(List<Order> list){
        Scanner scanner = new Scanner(System.in);
        System.out.println("Do you want to see Order Deatail(y/n):");
        String result = scanner.nextLine();
        while ("y".equalsIgnoreCase(result)) {
            System.out.print("Enter the order id you want to see details:");
            int chose = new Scanner(System.in).nextInt();
            if (chose >= 0 && chose < list.size()) {
                List<OrderDetail> orderDetailList = orderDetailDAO.showOrderDetail(chose);
                for (OrderDetail orderDetail : orderDetailList) {
                    System.out.println(orderDetail.toString());
                }
            } else {
                System.out.println("order id does not exist");
            }
            break;
        }
    }
}
