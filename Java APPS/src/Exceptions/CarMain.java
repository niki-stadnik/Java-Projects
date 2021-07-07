package Exceptions;

public class CarMain {
    public static void main(String[] args) {
        Car myCar = new Car("CB 1234 AA", "VW", 13);
        double fuel = myCar.calculateFuelConsumption(100);
        System.out.println(fuel);
    }
}
