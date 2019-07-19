package com.example.sysone.factories;

import com.example.sysone.entities.Opcion;
import com.example.sysone.enums.OpcionalesEnum;
import com.example.sysone.opciones.*;
import org.springframework.stereotype.Component;

@Component
public class OpcionFactory implements IOpcionFactory {

    public Opcion getOpcion(OpcionalesEnum opc) {
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
