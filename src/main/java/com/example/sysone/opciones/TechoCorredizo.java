package com.example.sysone.opciones;

import com.example.sysone.entities.Opcion;
import com.example.sysone.enums.OpcionalesEnum;

public class TechoCorredizo extends Opcion {

    {
        super.setName(OpcionalesEnum.TECHO_CORREDIZO.getName());
        super.setPrice(OpcionalesEnum.TECHO_CORREDIZO.getPrice());
    }
}
