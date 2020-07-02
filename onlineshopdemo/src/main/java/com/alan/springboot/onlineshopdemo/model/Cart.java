package com.alan.springboot.onlineshopdemo.model;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDateTime;

@Entity
@Table(name = "cart")
public class Cart implements Serializable {

    @Id
    @Column(name = "product_id")
    private int productId;

    @Id
    @Column(name = "username")
    private String username;


    @Column(name = "quantity")
    private int quantity;

    @Column(name = "order_time")
    @CreationTimestamp
    private LocalDateTime orderTime;

    @Column(name = "update_time")
    @UpdateTimestamp
    private LocalDateTime updateTime;


    public int getProductId() {
        return productId;
    }

    public void setProductId(int productId) {
        this.productId = productId;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public LocalDateTime getOrderTime() {
        return orderTime;
    }

    public void setOrderTime(LocalDateTime orderTime) {
        this.orderTime = orderTime;
    }

    public LocalDateTime getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(LocalDateTime updateTime) {
        this.updateTime = updateTime;
    }

    @Override
    public String toString() {
        return "Cart{" +
                "productId=" + productId +
                ", username='" + username + '\'' +
                ", quantity=" + quantity +
                ", orderTime=" + orderTime +
                ", updateTime=" + updateTime +
                '}';
    }
}
