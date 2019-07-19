package com.example.sysone;

import com.example.sysone.entities.Automovil;
import com.example.sysone.components.AutomovilOperation;
import com.example.sysone.enums.TiposAutomovilEnum;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SysoneApplication {

    public static void main(String[] args) {
        SpringApplication.run(SysoneApplication.class, args);

        AutomovilOperation operation = new AutomovilOperation();
        Automovil auto = new Automovil();
        auto.setName( TiposAutomovilEnum.COUPE.getName() );
        auto.setPrice( TiposAutomovilEnum.COUPE.getPrice() );

        System.out.println( operation.costo(auto) );
    }

}
