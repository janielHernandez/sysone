package com.example.sysone.components;


import com.example.sysone.entities.Automovil;
import com.example.sysone.enums.OpcionalesEnum;
import com.example.sysone.entities.Opcion;
import org.springframework.stereotype.Component;

@Component
public class AutomovilOperation {

    public Integer costo(Automovil auto){
        return (auto.getPrice()!=null?
                auto.getPrice():
                0) + this.costoOpcionales( auto );
    }

    private Integer costoOpcionales(Automovil auto){
        Integer costos = 0;
        for( Opcion op: auto.getOpciones() ){
            costos += OpcionalesEnum.getPriceFromName( op.getName() );
        }

        return costos;
    }


}
