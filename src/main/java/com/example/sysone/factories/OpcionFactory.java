package com.example.sysone.factories;

import com.example.sysone.entities.Opcion;
import com.example.sysone.enums.OpcionalesEnum;
import com.example.sysone.opciones.*;
import com.example.sysone.repositories.IOpcionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class OpcionFactory implements IOpcionFactory {


    @Autowired
    private IOpcionRepository opcionRepository;

    public Opcion getOpcion(OpcionalesEnum opc) {

        List <Opcion> o = opcionRepository.findByName( opc.getName() );
        if(o.size() > 0)
            return o.get(0);

        switch (opc){
            case TECHO_CORREDIZO:
                return new TechoCorredizo();
            case AIRE_ACONDICIONADO:
                return new AireAcondicionado();
            case LLANTA_ALEACION:
                return new LlantaAleacion();
            case SISTEMA_FRENO:
                return new SistemaFreno();
            case AIR_BAG:
                return new AirBag();
                default:
                    return null;
        }
    }
}
