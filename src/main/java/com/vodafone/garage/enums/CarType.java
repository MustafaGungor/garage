package com.vodafone.garage.enums;

public enum CarType {
    Car(1,"Car"),
    Jeep(2, "Jeep"),
    Truck(4, "Truck");

    public int value;
    public String name;

    CarType(int value,String name){
        this.value=value;
        this.name = name;
    }

    public int getValue() {
        return value;
    }

    public String getName() {
        return name;
    }
}
