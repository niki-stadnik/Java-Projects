package Exceptions;

public class Car {

    private String regNumber;
    private String model;
    private double fuelConsumption;

    public Car (String regNumber, String model, double fuelConsumption){
        this.regNumber= regNumber;
        this.model=model;
        this.fuelConsumption=fuelConsumption;
    }

    public double calculateFuelConsumption(double kilometers){
        return kilometers * fuelConsumption/100;
    }
}
