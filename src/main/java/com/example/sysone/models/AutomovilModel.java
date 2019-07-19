package com.example.sysone.models;

import org.springframework.lang.Nullable;

import java.util.LinkedList;
import java.util.List;

public class AutomovilModel {

    private Integer id;
    private String name;

    @Nullable
    private Integer price;
    private List<String> opciones = new LinkedList<>();


    public void update(AutomovilModel a){
        this.setName( a.getName() );
        this.setOpciones(a.getOpciones());
    }

    public Integer getPrice() {
        return price;
    }

    public void setPrice(Integer price) {
        this.price = price;
    }



    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<String> getOpciones() {
        return opciones;
    }

    public void setOpciones(List<String> opciones) {
        this.opciones = opciones;
    }
}
