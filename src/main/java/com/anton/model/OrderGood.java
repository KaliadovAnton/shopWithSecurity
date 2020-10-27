package com.anton.model;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name="Order_good")
public class OrderGood implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    public OrderGood(){

    }

    public OrderGood(Order order, Good good) {
        this.good = good;
        this.order = order;
    }

    @ManyToOne
    @JoinColumn(name="order_id", referencedColumnName = "id")
    private Order order;
    @ManyToOne
    @JoinColumn(name="good_id", referencedColumnName = "id")
    private Good good;

    @Override
    public String toString() {
        return "OrderGood{" +
                "id=" + id +
                ", order=" + order +
                ", good=" + good +
                '}';
    }
}
