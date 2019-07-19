package com.example.sysone.factories;

import com.example.sysone.entities.Opcion;
import com.example.sysone.enums.OpcionalesEnum;

public interface IOpcionFactory {
    Opcion getOpcion(OpcionalesEnum opc);
}
