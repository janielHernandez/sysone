package com.example.sysone.components;

import com.example.sysone.enums.OpcionalesEnum;
import com.example.sysone.enums.TiposAutomovilEnum;
import com.example.sysone.exceptions.NoValidNameOpcional;
import com.example.sysone.exceptions.NoValidaNameAuto;
import com.example.sysone.models.AutomovilModel;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class AutomovilValidator {

    public void validateAuto(AutomovilModel auto) throws NoValidNameOpcional, NoValidaNameAuto {

        if (  !validateAutoName(auto.getName()) )
            throw new NoValidaNameAuto();

        if (!validateOpciones(auto.getOpciones()) )
            throw new NoValidNameOpcional();
    }

    public Boolean validateOpciones(List<String> opciones ){

        for(String name: opciones){
            if (OpcionalesEnum.getFromName(name) == null )
                return false;
        }

        return true;

    }

    public Boolean validateAutoName(String name) {

        if ( TiposAutomovilEnum.getFromName(name) != null )
           return true;

        return false;

    }
}
