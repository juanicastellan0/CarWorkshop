package jic.app;

import jic.controllers.UserController;
import jic.models.User;

import java.util.ArrayList;
import java.util.Scanner;

class UserMenu {
    private static Scanner scanner = new Scanner(System.in);

    static void showUserMenu() {
        System.out.println("\n1. Add a user" +
                "\n2. Back");
        System.out.print("\nEnter an option: ");
    }

    static boolean handleUserMenuOptions(ArrayList<User> users) {
        int option = scanner.nextInt();

        switch (option) {
            case 1:
                System.out.println("\nAdding a user... ");
                UserController.add(users);
                return true;
            case 2:
                System.out.println("\nComing back");
                return false;
            default:
                System.out.println("\nIncorrect option, select other");
                return true;
        }
    }
}
