package com.example.oopsprojectbackend.rm;

import javax.persistence.*;

@Entity
@Table(name = "rm")
public class Rm {
    @Id
    @SequenceGenerator(
            name = "rm_sequence",
            sequenceName = "rm_sequence",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "rm_sequence"
    )
     private Long id;
     private String email;

     private String name;

     private Long uid;


    public Rm() {
    }

    public Rm(Long id, String email, String name, Long uid) {
        this.id = id;
        this.email = email;
        this.name = name;
        this.uid = uid;
    }

    public Rm(String email, String name, Long uid) {
        this.email = email;
        this.name = name;
        this.uid = uid;
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

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
    public Long getUid () {
        return uid;
    }

    public void setUid(Long uid) {
        this.uid = uid;
    }

    @Override
    public String toString() {
        return "Rm{" +
                "id=" + id +
                ", email='" + email + '\'' +
                ", name=" + name + '\'' +
                ", uid=" + uid + '\'' +
                '}';
    }
}
