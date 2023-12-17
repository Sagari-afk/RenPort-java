package com.example.demo.renport;

import com.example.demo.renport.models.*;

public class Validator {

    public static String validateVehicleType(Vehicle obj){
        String temp = obj.getVehicleType().toLowerCase();
        obj.setVehicleType(temp);
        System.out.println(obj.getVehicleType());
        return temp;
    }

    public static Vehicle changeType(Vehicle obj){
        switch (obj.getVehicleType()) {
            case "car" -> {
                obj = (Car) obj;
            }
            case "bike" -> {
                obj = (Bike) obj;
            }
            case "ecar" -> {
                obj = (ECar) obj;
            }
            case "ebike" -> {
                obj = (EBike) obj;
            }
            case "trackToys" -> {
                obj = (TrackToys) obj;
            }
            case "camping" -> {
                obj = (Camping) obj;
            }
        }
        return obj;
    }
}
