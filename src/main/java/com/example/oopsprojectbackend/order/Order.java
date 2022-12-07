package com.example.oopsprojectbackend.order;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "itemorder")
public class Order {
    @Id
    @SequenceGenerator(
            name = "order_sequence",
            sequenceName = "order_sequence",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "order_sequence"
    )
     private Long id;
     private Long uid;
     private Long pid;
     private Integer quantity;

     private LocalDate orderDate;

     private String address;

    public Order() {
    }

    public Order(Long id, Long uid, Long pid, Integer quantity, LocalDate orderDate, String address) {
        this.id = id;
        this.uid = uid;
        this.pid = pid;
        this.quantity = quantity;
        this.orderDate = orderDate;
        this.address = address;
    }

    public Order(Long uid, Long pid, Integer quantity, LocalDate orderDate, String address) {
        this.uid = uid;
        this.pid = pid;
        this.quantity = quantity;
        this.orderDate = orderDate;
        this.address = address;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getUid() {
        return uid;
    }

    public void setUid(Long uid) {
        this.uid = uid;
    }

    public Long getPid() {
        return pid;
    }

    public void setPid(Long pid) {
        this.pid = pid;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    public LocalDate getOrderDate() {
        return orderDate;
    }

    public void setOrderDate(LocalDate date) {
        this.orderDate = date;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    @Override
    public String toString() {
        return "Order{" +
                "id=" + id +
                "uid=" + uid +
                "pid=" + pid +
                "quantity=" + quantity +
                "orderDate" + orderDate +
                "address" + address +
                '}';
    }
}
