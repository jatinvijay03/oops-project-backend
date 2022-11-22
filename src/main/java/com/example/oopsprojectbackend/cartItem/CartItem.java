package com.example.oopsprojectbackend.cartItem;

import javax.persistence.*;

@Entity
@Table
public class CartItem {
    @Id
    @SequenceGenerator(
            name = "cartItem_sequence",
            sequenceName = "cartItem_sequence",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "cartItem_sequence"
    )
     private Long id;
     private Long uid;
     private Long pid;
     private Integer quantity;

    public CartItem() {
    }

    public CartItem(Long id, Long uid, Long pid, Integer quantity) {
        this.id = id;
        this.uid = uid;
        this.pid = pid;
        this.quantity = quantity;
    }

    public CartItem(Long uid, Long pid, Integer quantity) {
        this.uid = uid;
        this.pid = pid;
        this.quantity = quantity;
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

    @Override
    public String toString() {
        return "CartItem{" +
                "id=" + id +
                "uid=" + uid +
                "pid=" + pid +
                "quantity=" + quantity +
                '}';
    }
}
