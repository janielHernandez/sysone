package com.example.sysone.entities;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;


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
    private Set<Opcion> opciones = new HashSet<>();


   public void addOpcion(Opcion op){

        opciones.add(op);
    }

    public void deleteOpcion(Opcion op){

        opciones.remove(op);
    }

    public Set<Opcion> getOpciones() {

        return this.opciones;
    }
    public void setOpciones(Set<Opcion> opciones) {

        this.opciones = opciones;
    }
}
