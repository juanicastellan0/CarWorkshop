package jic.app;

import jic.controllers.RepairOrderController;
import jic.models.Car;
import jic.models.RepairOrder;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.Scanner;

public class RepairOrderMenu {
    private static Scanner scanner = new Scanner(System.in);

    static void showRepairOrderMenu() {
        System.out.println("\n1. Add a repair order" +
                "\n2. List repair orders" +
                "\n3. Update a repair order" +
                "\n4. Back");
        System.out.print("\nEnter an option: ");
    }

    static boolean handleRepairOrderMenuOptions(ArrayList<RepairOrder> repair_orders, ArrayList<Car> cars) throws ParseException {
        int option = scanner.nextInt();

        switch (option) {
            case 1:
                RepairOrderController.add(repair_orders, cars);
                return true;
            case 2:
                RepairOrderController.index(repair_orders);
                return true;
            case 3:
                RepairOrderController.update(repair_orders, cars);
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
