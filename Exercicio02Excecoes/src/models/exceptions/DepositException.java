package models.exceptions;

public class DepositException extends Exception { //nesse exemplo poderia ser RunException ou Exception.
    public DepositException(String message) {
        super(message);
    }
}