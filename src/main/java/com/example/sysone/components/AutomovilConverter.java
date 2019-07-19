package com.example.sysone.components;

import com.example.sysone.entities.Automovil;
import com.example.sysone.enums.OpcionalesEnum;
import com.example.sysone.enums.TiposAutomovilEnum;
import com.example.sysone.factories.IOpcionFactory;
import com.example.sysone.models.AutomovilModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class AutomovilConverter {

    @Autowired
    private AutomovilOperation operations;

    @Autowired
    private IOpcionFactory opcionFactory;

    public List<AutomovilModel> entityToModelList(List<Automovil> autos){

        return autos
                .stream()
                .map( x-> this.entityToModel(x) )
                .collect(Collectors.toList());
    }

    public AutomovilModel entityToModel(Automovil auto){


        auto.setPrice(TiposAutomovilEnum.getPriceFromName( auto.getName() ));
        AutomovilModel model = new AutomovilModel();

        model.setId( auto.getId() );
        model.setName( auto.getName() );
        model.setPrice( operations.costo(auto) );
        model.setOpciones(
                auto.getOpciones()
                .stream()
                .map(x -> x.getName())
                .collect(Collectors.toSet())
        );

        return model;

    }

    public Automovil modelToEntity(AutomovilModel auto){
        Automovil entity = new Automovil();
        entity.setId( auto.getId() );
        entity.setName( auto.getName() );
        entity.setOpciones(
                auto.getOpciones()
                        .stream()
                        .map(
                        x-> opcionFactory.getOpcion( OpcionalesEnum.getFromName(x) )
                        )
                        .collect(Collectors.toSet())

        );
        return entity;
    }


}
