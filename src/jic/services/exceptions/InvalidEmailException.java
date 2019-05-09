package jic.services.exceptions;

public class InvalidEmailException extends Exception {
    private String email;

    public InvalidEmailException(String email) {
        this.email = email;
    }

    public String toString() {
        return "InvalidEmailException[" + this.email + "]";
    }
}
