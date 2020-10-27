package com.anton.model;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name="`order`")
public class Order implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private Long id;
    @Column(name = "user_id")
    private long userId;
    @Column(name = "total")
    private double total;

    public Order(){}

    public Order(long userId, double total) {
        this.userId = userId;
        this.total = total;
    }

    public double getTotal() {
        return total;
    }

    public long getUserID() {
        return userId;
    }

    public void setId(Long executeUpdate) {
        id=executeUpdate;
    }

    public Long getId() {
        return id;
    }

    public void setTotal(double total) {
        this.total = total;
    }

    @Override
    public String toString() {
        return "Order{" +
                "id=" + id +
                ", userId=" + userId +
                ", total=" + total +
                '}';
    }
}
