package jic.services.exceptions;

public class InvalidNameException extends Exception {
    private String name;

    public InvalidNameException(String name) {
        this.name = name;
    }

    public String toString() {
        return "InvalidNameException[" + this.name + "]";
    }
}
