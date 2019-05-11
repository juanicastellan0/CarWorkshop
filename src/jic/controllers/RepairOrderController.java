package jic.controllers;


import jic.models.Car;
import jic.models.RepairOrder;


import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Scanner;

public class RepairOrderController {
    private static Scanner scanner = new Scanner(System.in);

    public static void add(ArrayList<RepairOrder> repair_orders, ArrayList<Car> cars) throws ParseException {
        System.out.println("\nEnter a car");
        Car car = Car.search(scanner, cars);

        System.out.println("\nEnter a problem description");
        String problem_description = scanner.nextLine();

        System.out.println("\nEnter the repair price");
        Long repair_price = scanner.nextLong();

        SimpleDateFormat date_formatter = new SimpleDateFormat("dd/MM/yyyy");

        RepairOrder repair_order = new RepairOrder(
                car,
                problem_description,
                enterAdmissionDate(date_formatter),
                enterRepairDate(date_formatter),
                repair_price);

        repair_orders.add(repair_order);
    }

    public static void index(ArrayList<RepairOrder> repair_orders) {
        if (repair_orders.isEmpty()) {
            System.out.println("Repair order list is empty");
        }

        System.out.println("\nRepair orders: ");
        for (RepairOrder repair_order : repair_orders) {
            System.out.println("- car: " + repair_order.getCar() +
                    "\n- repair price: " + repair_order.getRepairPrice());
        }
    }

    public static void update(ArrayList<RepairOrder> repair_orders, ArrayList<Car> cars) throws ParseException {
        RepairOrderController.index(repair_orders);

        System.out.println("\nSelect a repair order to update");
        RepairOrder repair_order = RepairOrder.search(scanner, repair_orders);
        if (repair_order != null) {
            System.out.println("\nEnter a car");
            repair_order.setCar(Car.search(scanner, cars));
            System.out.println("\nEnter the problem description");
            repair_order.setProblemDescription(scanner.nextLine());

            SimpleDateFormat date_formatter = new SimpleDateFormat("dd/MM/yyyy");

            System.out.println("\nEnter a admission date");
            repair_order.setAdmissionDate(enterAdmissionDate(date_formatter));
            System.out.println("\nEnter the repair date");
            repair_order.setRepairDate(enterRepairDate(date_formatter));
            System.out.println("\nEnter a repair price");
            repair_order.setRepairPrice(scanner.nextLong());
        }
    }
    private static Date enterAdmissionDate(SimpleDateFormat date_formatter) throws ParseException {
        System.out.println("\nEnter the admission date with this format: dd/MM/yyyy");
        String string_admission_date = scanner.nextLine();
        return date_formatter.parse(string_admission_date);
    }

    private static Date enterRepairDate(SimpleDateFormat date_formatter) throws ParseException {
        System.out.println("\nEnter the repair date with this format: dd/MM/yyyy");
        String string_repair_date = scanner.nextLine();
        return date_formatter.parse(string_repair_date);
    }
}
