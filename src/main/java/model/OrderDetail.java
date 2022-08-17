package model;

public class OrderDetail {
    private int cartId, quantity;
    private double total;
    private int orderId, productId;

    public OrderDetail() {
    }
    public OrderDetail(int cartId, int quantity, double total, int productId) {
        this.cartId = cartId;
        this.quantity = quantity;
        this.total = total;
        this.productId = productId;
    }
    public OrderDetail(int cartId, int quantity, double total, int orderId, int productId) {
        this.cartId = cartId;
        this.quantity = quantity;
        this.total = total;
        this.orderId = orderId;
        this.productId = productId;
    }

    public int getCartId() {
        return cartId;
    }

    public void setCartId(int cartId) {
        this.cartId = cartId;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public double getTotal() {
        return total;
    }

    public void setTotal(double total) {
        this.total = total;
    }

    public int getOrderId() {
        return orderId;
    }

    public void setOrderId(int orderId) {
        this.orderId = orderId;
    }

    public int getProductId() {
        return productId;
    }

    public void setProductId(int productId) {
        this.productId = productId;
    }

    @Override
    public String toString() {
        return "OrderDetail{" +
                "cartId=" + cartId +
                ", quantity=" + quantity +
                ", total=" + total +
                ", orderId=" + orderId +
                ", productId=" + productId +
                '}';
    }
    public void output()
    {
        System.out.printf("\n%15d %10d %15.2f %15d %15d",cartId,quantity,total,orderId, productId);
    }
}
