package jic.services.exceptions;

public class InvalidPasswordException extends Exception {
    private String password;

    public InvalidPasswordException(String password) {
        this.password = password;
    }

    public String toString() {
        return "InvalidPasswordException[" + this.password + "]";
    }
}
