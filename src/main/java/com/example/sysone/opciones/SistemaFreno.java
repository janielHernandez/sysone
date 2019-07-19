package com.example.sysone.opciones;

import com.example.sysone.entities.Opcion;
import com.example.sysone.enums.OpcionalesEnum;

public class SistemaFreno extends Opcion {

    {
        super.setName(OpcionalesEnum.SISTEMA_FRENO.getName());
        super.setPrice(OpcionalesEnum.SISTEMA_FRENO.getPrice());
    }
}
