package jic.controllers;

import jic.models.Car;
import jic.models.User;

import java.util.ArrayList;
import java.util.Scanner;

public class UserController {
    private static Scanner scanner = new Scanner(System.in);

    public static void add(ArrayList<User> users) {
        System.out.println("\nEnter a email");
        String email = User.tryToSetEmailOrFail(scanner);
        System.out.println("\nEnter a password");
        String password = User.tryToSetPasswordOrFail(scanner);
        User user = new User(email, password);

        users.add(user);
    }


    public static void index(ArrayList<User> users) {
        if (users.isEmpty()) {
            System.out.println("Users list is empty");
        }

        System.out.println("\nUsers: ");
        for (User user : users) {
            System.out.println("- email: " + user.getEmail());
        }
    }
}
