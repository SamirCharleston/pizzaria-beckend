package com.example.pizzariabackend.pizzariabackend.config.customExceptions;

public class OrderAlreadyDeliveredException extends RuntimeException {
    public OrderAlreadyDeliveredException(String message) {
        super(message);
    }
}
