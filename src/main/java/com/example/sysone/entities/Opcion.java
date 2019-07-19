package com.example.sysone.entities;

import com.example.sysone.entities.Product;
import javax.persistence.Entity;

@Entity
public class Opcion extends Product {

    public Opcion(String name,Integer price) {
        super(name, price);
    }

    public Opcion() { }



}
