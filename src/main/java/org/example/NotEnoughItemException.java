package org.example;

public class NotEnoughItemException extends RuntimeException {
    public NotEnoughItemException(String message) {
        super(message);
    }
}

