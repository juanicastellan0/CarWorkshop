package jic.app;

import jic.models.RepairOrder;

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

    static boolean handleRepairOrderMenuOptions(ArrayList<RepairOrder> repair_orders) {
        int option = scanner.nextInt();

        switch (option) {
            case 1:
                return true;
            case 2:
                return true;
            case 3:
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
