package com.example.sysone.enums;

import java.util.Arrays;

public enum OpcionalesEnum {

    TECHO_CORREDIZO("TC", 12_000),
    AIRE_ACONDICIONADO("AA", 20_000),
    SISTEMA_FRENO("ABS", 14_000),
    AIR_BAG("AB", 7_000),
    LLANTA_ALEACION("LL", 12_000);

    private String name;
    private Integer price;

    OpcionalesEnum(String name, Integer price){
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
            Arrays.asList( OpcionalesEnum.values() )
                .stream()
                .filter(x->x.name.equals( name ) )
                .findFirst()
                .get()
                .price;

    }

    public static OpcionalesEnum getFromName(String name){
        return
                Arrays.asList( OpcionalesEnum.values() )
                        .stream()
                        .filter(x->x.name.equals( name ) )
                        .findFirst()
                        .orElse(null);
    }
}
