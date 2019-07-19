package com.example.sysone.entities;


import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table
@Inheritance( strategy = InheritanceType.TABLE_PER_CLASS )
public class Product implements Serializable {


    @Id
    @GeneratedValue( strategy = GenerationType.AUTO )
    private Integer id;

    @Transient
    private Integer price;
    private String name;

    public Product() { }


    public Product(String name,Integer price) {
        this.price = price;
        this.name = name;
    }

    public Integer getId() { return id; }

    public void setId(Integer id) { this.id = id; }

    public Integer getPrice() {
        return price;
    }

    public void setPrice(Integer price) {
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {


        this.name = name;
    }

    private Boolean validateName(String name){
        return true;
    }

}