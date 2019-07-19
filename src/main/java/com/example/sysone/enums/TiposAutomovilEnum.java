package com.example.sysone.enums;

import com.example.sysone.components.AutomovilValidator;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Arrays;

public enum TiposAutomovilEnum {

    FAMILIAR("Familiar", 245_000),
    COUPE("Coupé", 270_000),
    SEDAN("Sedán", 230_000);

    private String name;
    private Integer price;

    @Autowired
            private AutomovilValidator a;

    TiposAutomovilEnum(String name, Integer price){
        this.name = name;
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getPrice() {
        return price;
    }

    public void setPrice(Integer price) {
        this.price = price;
    }

    public static Integer getPriceFromName(String name){
        return
                Arrays.asList( TiposAutomovilEnum.values() )
                        .stream()
                        .filter(x->x.name.equals( name ) )
                        .findFirst()
                        .get()
                        .price;
    }

    public static TiposAutomovilEnum getFromName(String name){
        return
                Arrays.asList( TiposAutomovilEnum.values() )
                        .stream()
                        .filter(x->x.name.equalsIgnoreCase( name ) )
                        .findFirst()
                        .orElse(null);
    }

}
