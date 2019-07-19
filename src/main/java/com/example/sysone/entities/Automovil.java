package com.example.sysone.entities;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;


@Entity
public class Automovil extends Product {


    public Automovil(){ }

    public Automovil(String name, Integer price){
        super(name, price);
    }

    @ManyToMany(cascade = { CascadeType.PERSIST, CascadeType.MERGE })
    @JoinTable(name = "automovil_opcion",
            joinColumns = @JoinColumn(name = "auto_id"),
            inverseJoinColumns = @JoinColumn(name = "opcion_id")
    )
    private List<Opcion> opciones = new ArrayList<>();


   public void addOpcion(Opcion op){

        opciones.add(op);
    }

    public void deleteOpcion(Opcion op){

        opciones.remove(op);
    }

    public List<Opcion> getOpciones() {

        return this.opciones;
    }
    public void setOpciones(List<Opcion> opciones) {

        this.opciones = opciones;
    }
}
