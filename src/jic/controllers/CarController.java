package jic.controllers;

import jic.models.Car;
import jic.models.Customer;

import java.util.ArrayList;
import java.util.Scanner;

public class CarController {
    private static Scanner scanner = new Scanner(System.in);

    public static void add(ArrayList<Car> cars, ArrayList<Customer> customers) {
        System.out.println("\nEnter a color");
        String color = scanner.nextLine();
        System.out.println("\nEnter a engine");
        String engine = scanner.nextLine();
        System.out.println("\nEnter a model");
        String model = scanner.nextLine();

        CustomerController.index(customers);
        System.out.println("\nEnter a owner");
        Customer owner = Customer.search(scanner, customers);

        Car car = new Car(color, engine, model, owner);

        cars.add(car);
    }

    public static void index(ArrayList<Car> cars) {
        if (cars.isEmpty()) {
            System.out.println("\nCars: ");
            System.out.println("Cars list is empty");
        }

        for (Car car : cars) {
            System.out.println("- model: " + car.getModel() + "- color: " + car.getColor());
        }
    }

    public static void update(ArrayList<Car> cars, ArrayList<Customer> customers) {
        CarController.index(cars);

        System.out.println("\nSelect a user to update");
        Car car = Car.search(scanner, cars);
        if (car != null) {
            System.out.println("\nEnter a color");
            car.setColor(scanner.nextLine());
            System.out.println("\nEnter a engine");
            car.setEngine(scanner.nextLine());
            System.out.println("\nEnter a model");
            car.setModel(scanner.nextLine());
            System.out.println("\nEnter the owner");
            car.setOwner(Customer.search(scanner, customers));
        }
    }
}
