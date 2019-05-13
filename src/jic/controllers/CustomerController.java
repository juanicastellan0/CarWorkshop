package jic.controllers;

import jic.helpers.Model;
import jic.models.Customer;
import jic.models.User;
import jic.services.CustomerDataValidator;
import jic.services.UserDataValidator;

import java.util.ArrayList;
import java.util.Scanner;

public class CustomerController {
    private static Scanner scanner = new Scanner(System.in);

    public static void add(ArrayList<Customer> customers) {
        Customer customer = new Customer(scanName(), scanEmail(), scanDni(), scanPhone(), scanIsRegularClient());

        customers.add(customer);
    }

    public static void index(ArrayList<Customer> customers) {
        if (customers.isEmpty()) {
            System.out.println("Customers list is empty");
        }

        System.out.println("\nCustomers: ");
        for (Customer customer : customers) {
            System.out.println("- " + customer.getName());
        }
    }

    public static void update(ArrayList<Customer> customers) {
        CustomerController.index(customers);

        System.out.println("\nSelect a customer to update");
        // @todo why this?
        Customer customer = Customer.search(scanner, customers);
        boolean customer_not_found = true;
        while (customer_not_found) {
            if (customer != null) {
                customer_not_found = false;
                System.out.println("\nEnter a name");
                customer.setName(Customer.tryToSetNameOrFail(scanner), scanner);
                System.out.println("\nEnter a email");
                customer.setEmail(User.tryToSetEmailOrFail(scanner), scanner);
                System.out.println("\nEnter a dni");
                customer.setDni(scanner.nextLong(), scanner);
                System.out.println("\nEnter a phone");
                customer.setPhone(Customer.tryToSetPhoneOrFail(scanner), scanner);
                customer.setIsRegularClient(Customer.scanIsRegularClient(scanner), scanner);
            } else {
                System.out.println("Customer not found");
                customer_not_found = true;
            }
        }
    }

    private static String scanName() {
        String name = "";
        boolean throw_exception = false;
        while (!throw_exception) {
            try {
                System.out.println("\nEnter a name");
                name = scanner.nextLine();
                Customer.validateAttribute(CustomerDataValidator.class.toString(), "name", name);
                throw_exception = false;
            } catch (Exception exception) {
                System.out.println(exception.toString());
                throw_exception = true;
            }
        }
        return name;
    }

    private static String scanEmail() {
        String email = "";
        boolean throw_exception = false;
        while (!throw_exception) {
            try {
                System.out.println("\nEnter a email");
                email = scanner.nextLine();
                Customer.validateAttribute(UserDataValidator.class.toString(), "email", email);
                throw_exception = false;
            } catch (Exception exception) {
                System.out.println(exception.toString());
                throw_exception = true;
            }
        }
        return email;
    }

    private static String scanPhone() {
        String phone = "";
        boolean throw_exception = false;
        while (!throw_exception) {
            try {
                System.out.println("\nEnter a phone");
                phone = scanner.nextLine();
                Customer.validateAttribute(CustomerDataValidator.class.toString(), "phone", phone);
                throw_exception = false;
            } catch (Exception exception) {
                System.out.println(exception.toString());
                throw_exception = true;
            }
        }
        return phone;
    }

    private static boolean scanIsRegularClient() {
        System.out.println("\nEnter if is a regular client or not." +
                "\nThat is, if he visits your workshop more than once a year " +
                " yes/no : ");
        return scanner.nextLine().equals("yes");
    }

    private static Long scanDni() {
        System.out.println("\nEnter a dni");
        return scanner.nextLong();
    }
}
