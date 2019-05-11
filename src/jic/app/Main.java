package jic.app;

import jic.models.Car;
import jic.models.Customer;
import jic.models.RepairOrder;
import jic.models.User;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    private static Scanner scanner = new Scanner(System.in);
    private static ArrayList<User> users;
    private static ArrayList<Customer> customers;
    private static ArrayList<Car> cars;
    private static ArrayList<RepairOrder> repair_orders;

    public static void main(String[] args) throws ParseException {
        boolean not_want_exit = true;
        users = new ArrayList<>(10);
        customers = new ArrayList<>(10);
        cars = new ArrayList<>(10);
        repair_orders = new ArrayList<>(10);

        while (not_want_exit) {
            Main.showMainMenu();
            not_want_exit = handleMainMenuOptions();
        }
    }

    private static void showMainMenu() {
        System.out.println("\nWhat do you want to do?" +
                "\n1. Manage users" +
                "\n2. Manage customers" +
                "\n3. Manage cars" +
                "\n4. Manage repair orders" +
                "\n5. Exit");
        System.out.print("\nEnter an option: ");
    }

    private static boolean handleMainMenuOptions() throws ParseException {
        int option = scanner.nextInt();
        boolean not_want_back;
        switch (option) {
            case 1:
                not_want_back = true;
                while (not_want_back) {
                    UserMenu.showUserMenu();
                    not_want_back = UserMenu.handleUserMenuOptions(users);
                }
                return true;
            case 2:
                not_want_back = true;
                while (not_want_back) {
                    CustomerMenu.showCustomerMenu();
                    not_want_back = CustomerMenu.handleCustomerMenuOptions(customers);
                }
                return true;
            case 3:
                not_want_back = true;
                while (not_want_back) {
                    CarMenu.showCarMenu();
                    not_want_back = CarMenu.handleCarMenuOptions(cars, customers);
                }
                return true;
            case 4:
                not_want_back = true;
                while (not_want_back) {
                    RepairOrderMenu.showRepairOrderMenu();
                    not_want_back = RepairOrderMenu.handleRepairOrderMenuOptions(repair_orders, cars);
                }
                return true;
            case 5:
                return false;
            default:
                System.out.println("\nIncorrect option, select other");
                return true;
        }
    }
}
