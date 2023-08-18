package com.example.pizzariabackend.pizzariabackend.config.customExceptions;

public class OrderCanceledException extends RuntimeException {
    public OrderCanceledException(String message){
        super(message);
    }
}
