package iuh.fit.edu.thanhoangthienthien_tuan04_bai04.beans;


public class Order {
    private String fullName;
    private String shippingAddress;
    private double totalPrice;
    private String paymentMethod;

    public Order() {}

    public Order(String fullName, String shippingAddress, double totalPrice, String paymentMethod) {
        this.fullName = fullName;
        this.shippingAddress = shippingAddress;
        this.totalPrice = totalPrice;
        this.paymentMethod = paymentMethod;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getShippingAddress() {
        return shippingAddress;
    }

    public void setShippingAddress(String shippingAddress) {
        this.shippingAddress = shippingAddress;
    }

    public double getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(double totalPrice) {
        this.totalPrice = totalPrice;
    }

    public String getPaymentMethod() {
        return paymentMethod;
    }

    public void setPaymentMethod(String paymentMethod) {
        this.paymentMethod = paymentMethod;
    }

    @Override
    public String toString() {
        return "Order{" +
                "fullName='" + fullName + '\'' +
                ", shippingAddress='" + shippingAddress + '\'' +
                ", totalPrice=" + totalPrice +
                ", paymentMethod='" + paymentMethod + '\'' +
                '}';
    }
}

