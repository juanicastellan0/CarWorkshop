package jic.controllers;


import jic.models.Car;
import jic.models.Customer;
import jic.models.RepairOrder;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Scanner;

public class RepairOrderController {
    private static Scanner scanner = new Scanner(System.in);

    public static void add(ArrayList<RepairOrder>, ArrayList<Car> cars, ArrayList<Customer> customers) throws ParseException {
        System.out.println("\nEnter a car");
        Car car = Car.search(scanner, cars);
        System.out.println("\nEnter a problem description");
        String problem_description = scanner.nextLine();
        System.out.println("\nEnter the admission date with this format: dd/MM/yyyy");
        String string_admission_date = scanner.nextLine();
        SimpleDateFormat date_formatter = new SimpleDateFormat("dd/MM/yyyy");
        Date admission_date = date_formatter.parse(string_admission_date);
        System.out.println("\nEnter the repair date");
        System.out.println("\nEnter the repair price");

        CustomerController.index(customers);
        System.out.println("\nEnter a owner");
        Customer owner = Customer.search(scanner, customers);

        RepairOrder repair_order = new RepairOrder(car, problem_description, admission_date, repair_date, repair_price);

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
