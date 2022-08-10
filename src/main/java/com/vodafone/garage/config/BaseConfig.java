package com.vodafone.garage.config;

import com.vodafone.garage.exception.ServerErrorException;
import com.vodafone.garage.model.Car;
import com.vodafone.garage.model.GarageResponse;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;

public abstract class BaseConfig {
    public static ArrayList<Integer> left;
    public static int total_size;
    public static ConcurrentHashMap<Integer, Car> parkingList = new ConcurrentHashMap<>();
    public abstract void setPark(String[] commandArray) throws ServerErrorException;
    public GarageResponse garageResponse;
    public static List<String> lastStateList = new ArrayList<>();
}
