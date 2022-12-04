package com.example.oopsprojectbackend.wallet;

import javax.persistence.*;
import javax.persistence.criteria.CriteriaBuilder;

@Entity
@Table
public class Wallet {
    @Id
    @SequenceGenerator(
            name = "wallet_sequence",
            sequenceName = "wallet_sequence",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "wallet_sequence"
    )
     private Long id;
     private Long uid;
     private Integer amount;

     private String pin;

    public Wallet() {
    }

    public Wallet(Long id, Long uid, Integer amount, String pin) {
        this.id = id;
        this.uid = uid;
        this.amount = amount;
        this.pin = pin;
    }

    public Wallet(Long uid, Integer amount) {
        this.uid = uid;
        this.amount = amount;
        this.pin = pin;
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

    public Integer getAmount() {
        return amount;
    }

    public void setAmount(Integer amount) {
        this.amount = amount;
    }

    public String getPin() {
        return pin;
    }

    public void setPin(String pin) {
        this.pin = pin;
    }

    @Override
    public String toString() {
        return "Wallet{" +
                "id=" + id +
                ", uid='" + uid + '\'' +
                ", amount='" + amount + '\'' +
                ", pin='" + pin + '\'' +
                '}';
    }
}
