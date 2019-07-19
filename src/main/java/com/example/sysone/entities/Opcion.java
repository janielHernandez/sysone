package com.example.sysone.entities;

import com.example.sysone.entities.Product;
import javax.persistence.Entity;
import javax.persistence.ManyToMany;
import java.util.HashSet;
import java.util.Set;

@Entity
public class Opcion extends Product {

    public Opcion(String name,Integer price) {
        super(name, price);
    }

    public Opcion() { }

    @ManyToMany
    Set<Automovil> autos = new HashSet<>();

    public Set<Automovil> getAutos() {
        return autos;
    }

    public void setAutos(Set<Automovil> autos) {
        this.autos = autos;
    }







}
