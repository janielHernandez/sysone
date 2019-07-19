package com.example.sysone.opciones;

import com.example.sysone.entities.Opcion;
import com.example.sysone.enums.OpcionalesEnum;

public class AirBag extends Opcion {

    {
        super.setName(OpcionalesEnum.AIR_BAG.getName());
        super.setPrice(OpcionalesEnum.AIR_BAG.getPrice());
    }
}
