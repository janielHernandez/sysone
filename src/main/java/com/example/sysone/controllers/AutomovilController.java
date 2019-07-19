package com.example.sysone.controllers;

import com.example.sysone.models.AutomovilModel;
import com.example.sysone.services.IAutomovilService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("auto")
public class AutomovilController {

    @Autowired
    private IAutomovilService service;

    @GetMapping
    public List<AutomovilModel> listAuto(){
        return this.service.getAutos();
    }

    @GetMapping("{id}")
    public ResponseEntity<?> getAuto(@PathVariable Integer id){
        return this.service.getAuto(id);
    }

    @PostMapping
    public ResponseEntity<?> createAuto( @RequestBody AutomovilModel auto){
        return this.service.createAuto( auto );
    }

    @PutMapping("{id}")
    public ResponseEntity<?> update(@RequestBody AutomovilModel auto, @PathVariable Integer id){

        return this.service.updateAuto(auto, id);
    }

    @DeleteMapping("{id}")
    public ResponseEntity<?> delete(@PathVariable Integer id){
            return this.service.deteleAuto(id);
    }
}
