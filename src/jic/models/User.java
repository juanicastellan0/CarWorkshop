package jic.models;

import jic.services.UserDataValidator;
import jic.services.exceptions.InvalidEmailException;
import jic.services.exceptions.InvalidPasswordException;

import java.util.ArrayList;
import java.util.Scanner;

public class User {
    private String id;
    private String email;
    private String password;

    public User(String email, String password) {
        this.email = email;
        this.password = password;
    }

    private static void validateEmail(String email) throws InvalidEmailException {
        UserDataValidator.validateEmail(email);
    }

    private static void validatePassword(String password) throws InvalidPasswordException {
        UserDataValidator.validatePassword(password);
    }

    public String getEmail() {
        return email;
    }

//    private void setEmail(String email) {
//        this.email = email;
//    }

    public String getPassword() {
        return password;
    }

//    public void setPassword(String password) {
//        this.password = password;
//    }

    public static String tryToSetEmailOrFail(Scanner scanner) {
        boolean not_throw_exception = true;
        while (not_throw_exception) {
            try {
                String email = scanner.nextLine();
                validateEmail(email);
                return email;
            } catch (InvalidEmailException invalid_email) {
                System.out.println(invalid_email.toString());
                not_throw_exception = false;
            }
        }
        return "";
    }

    public static String tryToSetPasswordOrFail(Scanner scanner) {
        boolean not_throw_exception = true;
        while (not_throw_exception) {
            try {
                String password = scanner.nextLine();
                validatePassword(password);
                return password;
            } catch (InvalidPasswordException invalid_password) {
                System.out.println(invalid_password.toString());
                not_throw_exception = false;
            }
        }
        return "";
    }
}
