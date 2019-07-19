package com.example.sysone.services;


import com.example.sysone.models.AutomovilModel;
import org.springframework.http.ResponseEntity;
import java.util.List;

public interface IAutomovilService {
    List<AutomovilModel> getAutos();
    ResponseEntity<?> getAuto(Integer id);
    ResponseEntity<?> createAuto(AutomovilModel auto);
    ResponseEntity<?> deteleAuto(Integer id);
    ResponseEntity<?> updateAuto(AutomovilModel auto, Integer id);

}
