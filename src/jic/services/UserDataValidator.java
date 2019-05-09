package jic.services;

import jic.services.exceptions.InvalidEmailException;
import jic.services.exceptions.InvalidPasswordException;

public class UserDataValidator {
    private static final String EMAIL_REGEX = "^[A-Z0-9._%+-]+@[A-Z0-9.-]+\\.[A-Z]{2,6}$";
    private static final String PASSWORD_REGEX = "^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=.*[@#$%^&+=])(?=\\S+$).{8,}$";

    public static void validateEmail(String email) throws InvalidEmailException {
        if (!email.matches(EMAIL_REGEX)) {
            throw new InvalidEmailException(email);
        }
    }

    public static void validatePassword(String password) throws InvalidPasswordException {
        if (!password.matches(PASSWORD_REGEX)) {
            throw new InvalidPasswordException(password);
        }
    }
}
