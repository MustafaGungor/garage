package com.vodafone.garage.model;

import com.vodafone.garage.enums.CarType;

public class Car {
    String state;
    String plakaNo;
    String colour;
    CarType type;

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getPlakaNo() {
        return plakaNo;
    }

    public void setPlakaNo(String plakaNo) {
        this.plakaNo = plakaNo;
    }

    public String getColour() {
        return colour;
    }

    public void setColour(String colour) {
        this.colour = colour;
    }

    public CarType getType() {
        return type;
    }

    public void setType(CarType type) {
        this.type = type;
    }

    public Car(String state,String plakaNo, String colour, CarType type) {
        this.state = state;
        this.plakaNo = plakaNo;
        this.colour = colour;
        this.type = type;
    }
}
