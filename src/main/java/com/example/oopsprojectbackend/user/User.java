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
     private String state;

    public User() {
    }

    public User(Long id, String email, String password, String state) {
        this.id = id;
        this.email = email;
        this.password = password;
        this.state = state;
    }

    public User(String email, String password, String state) {
        this.email = email;
        this.password = password;
        this.state = state;
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

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", email='" + email + '\'' +
                ", password='" + password + '\'' +
                ", state=" + state + '\'' +
                '}';
    }
}
