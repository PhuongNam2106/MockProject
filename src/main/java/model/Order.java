package model;

import java.util.Date;

public class Order extends Customer{
    public int orderId;
    private String name;
    private String phoneNumber;
    private String detailAddress;
    private double total;
    private Date orderDate;
    private int customerId, addressID, discountId;

    public Order() {
    }

    public Order(int orderId, String name, String phoneNumber1, String detailAddress, double total, Date orderDate, int customerId,String fullName,  int addressID, int discountId) {
        super(fullName);
        this.orderId = orderId;
        this.name = name;
        this.phoneNumber = phoneNumber1;
        this.detailAddress = detailAddress;
        this.total = total;
        this.orderDate = orderDate;
        this.customerId = customerId;
        this.addressID = addressID;
        this.discountId = discountId;
    }

    public Order(int orderId, String name, String phoneNumber, String detailAddress, double total, Date orderDate, int customerId, int addressID, int discountId) {
        this.orderId = orderId;
        this.name = name;
        this.phoneNumber = phoneNumber;
        this.detailAddress = detailAddress;
        this.total = total;
        this.orderDate = orderDate;
        this.customerId = customerId;
        this.addressID = addressID;
        this.discountId = discountId;
    }

    public int getOrderId() {
        return orderId;
    }

    public void setOrderId(int orderId) {
        this.orderId = orderId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getDetailAddress() {
        return detailAddress;
    }

    public void setDetailAddress(String detailAddress) {
        this.detailAddress = detailAddress;
    }

    public double getTotal() {
        return total;
    }

    public void setTotal(double total) {
        this.total = total;
    }

    public Date getOrderDate() {
        return orderDate;
    }

    public void setOrderDate(Date orderDate) {
        this.orderDate = orderDate;
    }

    public int getCustomerId() {
        return customerId;
    }

    public void setCustomerId(int customerId) {
        this.customerId = customerId;
    }

    public int getAddressID() {
        return addressID;
    }

    public void setAddressID(int addressID) {
        this.addressID = addressID;
    }

    public int getDiscountId() {
        return discountId;
    }

    public void setDiscountId(int discountId) {
        this.discountId = discountId;
    }

    @Override
    public String toString() {
        return "Order{" +
                "orderId=" + orderId +
                ", name='" + name + '\'' +
                ", phoneNumber=" + phoneNumber +
                ", detailAddress='" + detailAddress + '\'' +
                ", total=" + total +
                ", orderDate=" + orderDate +
                ", customerId=" + customerId +
                ",customerName="+ super.getFullName()+
                ", addressID=" + addressID +
                ", discountId=" + discountId +
                '}';
    }
    public void output()
    {
        System.out.printf("\n%10d %30s %15s %30s %10s %15s %15d %30s %15s %10s",orderId,name,phoneNumber,detailAddress,total,orderDate,customerId,getFullName(),addressID,discountId);
    }
}
