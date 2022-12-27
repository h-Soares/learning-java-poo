package models.exceptions;

public class ContactDoesntExistException extends Exception {
    public ContactDoesntExistException(String message) {
        super(message);
    }
}
