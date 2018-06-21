package com.everis.tddstarter.bean;

public class UnitSystem {

    private String unit;
    private String middle;
    private String nextUnit;

    public UnitSystem(String unit, String middle, String nextUnit){
        this.unit = unit;
        this.middle = middle;
        this.nextUnit = nextUnit;
    }

    public String getUnit(){
        return unit;
    }

    public String getMiddle(){
        return middle;
    }

    public String getNextUnit(){
        return nextUnit;
    }
}