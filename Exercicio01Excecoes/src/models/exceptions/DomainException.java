package models.exceptions;

public class DomainException extends Exception {//se for RuntimeException, não é obrigado a tratar.
    public DomainException(String message) {
        super(message);
    }
}