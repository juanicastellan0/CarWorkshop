package jic.services.exceptions;

public class InvalidPhoneException extends Exception {
    private String phone;

    public InvalidPhoneException(String phone) {
        this.phone = phone;
    }

    public String toString() {
        return "InvalidPhoneException[" + this.phone + "]";
    }
}
