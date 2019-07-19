package com.example.sysone.opciones;

import com.example.sysone.entities.Opcion;
import com.example.sysone.enums.OpcionalesEnum;

public class LlantaAleacion extends Opcion {

    {
        super.setName(OpcionalesEnum.LLANTA_ALEACION.getName());
        super.setPrice(OpcionalesEnum.LLANTA_ALEACION.getPrice());
    }
}
