package jic.app;

import jic.controllers.CustomerController;
import jic.models.Customer;

import java.util.ArrayList;
import java.util.Scanner;

class CustomerMenu {
    private static Scanner scanner = new Scanner(System.in);

    static void showCustomerMenu() {
        System.out.println("\n1. Add a customer" +
                "\n2. List customers" +
                "\n3. Update a customer" +
                "\n4. Back");
        System.out.print("\nEnter an option: ");
    }

    static boolean handleCustomerMenuOptions(ArrayList<Customer> customers) {
        int option = scanner.nextInt();

        switch (option) {
            case 1:
                CustomerController.add(customers);
                return true;
            case 2:
                CustomerController.index(customers);
                return true;
            case 3:
                CustomerController.update(customers);
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
