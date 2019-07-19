package com.example.sysone.opciones;

import com.example.sysone.entities.Opcion;
import com.example.sysone.enums.OpcionalesEnum;

public class AireAcondicionado extends Opcion {

    {
        super.setName(OpcionalesEnum.AIRE_ACONDICIONADO.getName());
        super.setPrice(OpcionalesEnum.AIRE_ACONDICIONADO.getPrice());
    }
}
