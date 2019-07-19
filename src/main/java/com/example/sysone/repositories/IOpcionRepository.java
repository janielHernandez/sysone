package com.example.sysone.repositories;

import com.example.sysone.entities.Opcion;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface IOpcionRepository extends CrudRepository<Opcion, Integer>{

    List<Opcion> findByName(String email);
}
