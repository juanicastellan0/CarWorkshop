package jic.models;

import java.util.ArrayList;
import java.util.Scanner;

public class Car {
    String id;
    private String color;
    private String engine;
    private String model;
    private Customer owner;

    public Car(String color, String engine, String model, Customer owner) {
        this.color = color;
        this.engine = engine;
        this.model = model;
        this.owner = owner;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    private String getEngine() {
        return engine;
    }

    public void setEngine(String engine) {
        this.engine = engine;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public Customer getOwner() {
        return owner;
    }

    public void setOwner(Customer owner) {
        this.owner = owner;
    }

    public static Car search(Scanner scanner, ArrayList<Car> cars) {
        String engine_to_search;
        System.out.println("Enter the engine: ");
        engine_to_search = scanner.nextLine();
        for (Car car : cars) {
            if (car.getEngine().equals(engine_to_search)) {
                return car;
            }
        }
        System.out.println("Car not found: ");
        return null;
    }
}
