package jic.app;

import jic.controllers.CarController;
import jic.models.Car;
import jic.models.Customer;

import java.util.ArrayList;
import java.util.Scanner;

class CarMenu {
    private static Scanner scanner = new Scanner(System.in);

    static void showCarMenu() {
        System.out.println("\n1. Add a car" +
                "\n2. List cars" +
                "\n3. Update a car" +
                "\n4. Back");
        System.out.print("\nEnter an option: ");
    }

    static boolean handleCarMenuOptions(ArrayList<Car> cars, ArrayList<Customer> customers) {
        int option = scanner.nextInt();

        switch (option) {
            case 1:
                CarController.add(cars, customers);
                return true;
            case 2:
                CarController.index(cars);
                return true;
            case 3:
                CarController.update(cars);
                return true;
            case 4:
                System.out.println("\nComing back");
                return false;
            default:
                System.out.println("\nIncorrect option, select other");
                return true;
        }
    }
}
