package org.example;

public class NotRegisteredException extends RuntimeException {
    public NotRegisteredException(String name) {
        super(name);
    }
}
