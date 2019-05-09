package jic.services;

import jic.services.exceptions.InvalidNameException;
import jic.services.exceptions.InvalidPhoneException;

public class CustomerDataValidator {
    private static final String NAME_REGEX = "^[a-zA-Z\\s]+";
    private static final String PHONE_REGEX = "\\d{10}|(?:\\d{3}-){2}\\d{4}|\\(\\d{3}\\)\\d{3}-?\\d{4}";

    public static void validateName(String name) throws InvalidNameException {
        if (!name.matches(NAME_REGEX)) {
            throw new InvalidNameException(name);
        }
    }

    public static void validatePhone(String phone) throws InvalidPhoneException {
        if (!phone.matches(PHONE_REGEX)) {
            throw new InvalidPhoneException(phone);
        }
    }
}
