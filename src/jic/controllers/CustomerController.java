package jic.controllers;

import jic.models.Customer;
import jic.models.User;

import java.util.ArrayList;
import java.util.Scanner;

public class CustomerController {
    private static Scanner scanner = new Scanner(System.in);

    public static void add(ArrayList<Customer> customers) {
        System.out.println("\nEnter a name");
        String name = Customer.tryToSetNameOrFail(scanner);
        System.out.println("\nEnter a email");
        String email = User.tryToSetEmailOrFail(scanner);
        System.out.println("\nEnter a dni");
        Long dni = scanner.nextLong();
        System.out.println("\nEnter a phone");
        String phone = Customer.tryToSetPhoneOrFail(scanner);
        boolean is_regular_client = Customer.scanIsRegularClient(scanner);

        Customer customer = new Customer(name, email, dni, phone, is_regular_client);

        customers.add(customer);
    }

    public static void index(ArrayList<Customer> customers) {
        if (customers.isEmpty()) {
            System.out.println("\nCustomers: ");
            System.out.println("Customers list is empty");
        }

        for (Customer customer : customers) {
            System.out.println("- " + customer.getName());
        }
    }

    public static void update(ArrayList<Customer> customers) {
        CustomerController.index(customers);

        System.out.println("\nSelect a user to update");
        Customer customer = Customer.search(scanner, customers);
        if (customer != null) {
            System.out.println("\nEnter a name");
            customer.setName(Customer.tryToSetNameOrFail(scanner), scanner);
            System.out.println("\nEnter a email");
            customer.setEmail(User.tryToSetEmailOrFail(scanner), scanner);
            System.out.println("\nEnter a dni");
            customer.setDni(scanner.nextLong(), scanner);
            System.out.println("\nEnter a phone");
            customer.setPhone(Customer.tryToSetPhoneOrFail(scanner), scanner);
            customer.setIsRegularClient(Customer.scanIsRegularClient(scanner), scanner);
        }
    }
}
