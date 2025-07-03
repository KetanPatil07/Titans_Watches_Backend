package com.titan.entity;

import java.time.LocalDateTime;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "orders")
public class Order {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Long userId; // ✅ New field for tracking user who placed the order

    private String name;
    private String email;
    private String address;
    private int quantity;
    private String paymentMethod;

    private String productName;
    private String productImage;
    private String price;
    private double totalPrice;

    private LocalDateTime orderDate = LocalDateTime.now();
    private String status = "Pending";

    // ✅ Getters and Setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public String getPaymentMethod() {
        return paymentMethod;
    }

    public void setPaymentMethod(String paymentMethod) {
        this.paymentMethod = paymentMethod;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public String getProductImage() {
        return productImage;
    }

    public void setProductImage(String productImage) {
        this.productImage = productImage;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public double getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(double totalPrice) {
        this.totalPrice = totalPrice;
    }

    public LocalDateTime getOrderDate() {
        return orderDate;
    }

    public void setOrderDate(LocalDateTime orderDate) {
        this.orderDate = orderDate;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    // ✅ toString
    @Override
    public String toString() {
        return "Order [id=" + id + ", userId=" + userId + ", name=" + name + ", email=" + email +
                ", address=" + address + ", quantity=" + quantity + ", paymentMethod=" + paymentMethod +
                ", productName=" + productName + ", productImage=" + productImage + ", price=" + price +
                ", totalPrice=" + totalPrice + ", orderDate=" + orderDate + ", status=" + status + "]";
    }

    // ✅ All-args Constructor
    public Order(Long id, Long userId, String name, String email, String address, int quantity,
                 String paymentMethod, String productName, String productImage, String price,
                 double totalPrice, LocalDateTime orderDate, String status) {
        super();
        this.id = id;
        this.userId = userId;
        this.name = name;
        this.email = email;
        this.address = address;
        this.quantity = quantity;
        this.paymentMethod = paymentMethod;
        this.productName = productName;
        this.productImage = productImage;
        this.price = price;
        this.totalPrice = totalPrice;
        this.orderDate = orderDate;
        this.status = status;
    }

    // ✅ No-args Constructor
    public Order() {
        super();
    }
}
