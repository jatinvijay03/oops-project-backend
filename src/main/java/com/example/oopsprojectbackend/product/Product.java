package com.example.oopsprojectbackend.product;

import javax.persistence.*;
import java.time.LocalDate;
import java.time.Period;

@Entity
@Table
public class Product {
    @Id
    @SequenceGenerator(
            name = "product_sequence",
            sequenceName = "product_sequence",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "product_sequence"
    )
     private Long id;
     private String name;
     private String description;
     private String image;
     private Integer price;
     private Long category_id;

    public Product() {
    }

    public Product(Long id, String name, String description, String image, Integer price, Long category_id) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.image = image;
        this.price = price;
        this.category_id = category_id;
    }

    public Product(String name, String description, String image, Integer price, Long category_id) {
        this.name = name;
        this.description = description;
        this.image = image;
        this.price = price;
        this.category_id = category_id;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public Long getCategory_id() { return category_id; }

    public void setCategory_id(Long category_id) {this.category_id = category_id;}

    public Integer getPrice() {
        return price;
    }

    public void setPrice(Integer price) {this.price = price;}

    @Override
    public String toString() {
        return "Product{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", description='" + description + '\'' +
                ", image=" + image + '\'' +
                ", category_id=" + category_id + '\'' +
                ", price=" + price +
                '}';
    }
}
