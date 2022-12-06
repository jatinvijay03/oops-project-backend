package com.example.oopsprojectbackend.user;

import javax.persistence.*;

@Entity
@Table(name = "customers")
public class User {
    @Id
    @SequenceGenerator(
            name = "user_sequence",
            sequenceName = "user_sequence",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "user_sequence"
    )
     private Long id;
     private String email;
     private String password;
     private String address;

     private String role;

     private String name;

     private Long number;

    public User() {
    }

    public User(Long id, String email, String password, String address, String role, String name, Long number) {
        this.id = id;
        this.email = email;
        this.password = password;
        this.address = address;
        this.role = role;
        this.name = name;
        this.number = number;
    }

    public User(String email, String password, String address, String role, String name, Long number) {
        this.email = email;
        this.password = password;
        this.address = address;
        this.role = role;
        this.name = name;
        this.number = number;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public Long getNumber () {
        return number;
    }

    public void setNumber(Long number) {
        this.number = number;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", email='" + email + '\'' +
                ", password='" + password + '\'' +
                ", address=" + address + '\'' +
                ", name=" + name + '\'' +
                ", number=" + number + '\'' +
                ", role=" + role + '\'' +
                '}';
    }
}
