package jic.models;

import jic.helpers.Model;
import jic.services.CustomerDataValidator;
import jic.services.exceptions.InvalidNameException;
import jic.services.exceptions.InvalidPhoneException;

import java.util.Scanner;

public class Customer extends Model {
    private String name;
    private String email;
    private Long dni;
    private String phone;
    private boolean is_regular_client;

    public Customer(String name, String email, Long dni, String phone, boolean is_regular_client) {
        super();
        this.name = name;
        this.email = email;
        this.dni = dni;
        this.phone = phone;
        this.is_regular_client = is_regular_client;
    }

    public static String tryToSetNameOrFail(Scanner scanner) {
        boolean not_throw_exception = true;
        while (not_throw_exception) {
            try {
                String name = scanner.nextLine();
                CustomerDataValidator.validateName(name);
                return name;
            } catch (InvalidNameException invalid_name) {
                System.out.println(invalid_name.toString());
                not_throw_exception = false;
            }
        }
        return "";
    }

    public static String tryToSetPhoneOrFail(Scanner scanner) {
        boolean not_throw_exception = true;
        while (not_throw_exception) {
            try {
                String phone = scanner.nextLine();
                CustomerDataValidator.validatePhone(phone);
                return phone;
            } catch (InvalidPhoneException invalid_phone) {
                System.out.println(invalid_phone.toString());
                not_throw_exception = false;
            }
        }
        return "";
    }

    public String getName() {
        return name;
    }

    public void setName(String name, Scanner scanner) {
        System.out.println("Do you want to change the name? yes/no");
        boolean yes_wants = scanner.nextLine().equals("yes");
        if (yes_wants) {
            this.name = name;
        }
    }

    private String getEmail() {
        return email;
    }

    public void setEmail(String email, Scanner scanner) {
        System.out.println("Do you want to change the email? yes/no");
        boolean yes_wants = scanner.nextLine().equals("yes");
        if (yes_wants) {
            this.email = email;
        }
    }

//    public Long getDni() {
//        return dni;
//    }

    public void setDni(Long dni, Scanner scanner) {
        System.out.println("Do you want to change the dni? yes/no");
        boolean yes_wants = scanner.nextLine().equals("yes");
        if (yes_wants) {
            this.dni = dni;
        }
    }

//    public String getPhone() {
//        return phone;
//    }

    public void setPhone(String phone, Scanner scanner) {
        System.out.println("Do you want to change the phone? yes/no");
        boolean yes_wants = scanner.nextLine().equals("yes");
        if (yes_wants) {
            this.phone = phone;
        }
    }

//    public boolean getIsRegularClient() {
//        return is_regular_client;
//    }

    public void setIsRegularClient(boolean is_regular_client, Scanner scanner) {
        System.out.println("Do you want to change the email? yes/no");
        boolean yes_wants = scanner.nextLine().equals("yes");
        if (yes_wants) {
            this.is_regular_client = is_regular_client;
        }
    }


}
