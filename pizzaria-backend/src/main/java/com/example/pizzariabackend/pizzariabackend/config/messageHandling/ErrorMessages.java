package com.example.pizzariabackend.pizzariabackend.config.messageHandling;

public abstract class ErrorMessages {
    public static final String SPACE_AND_LETTERS = "This field must contain only spaces and alphabetic characters.";
    public static final String ONLY_NUMBERS = "This field must contain only numbers.";
    public static final String ONLY_LETTERS = "This field must contain only alphabetic characters.";
    public static final String CPF = "This field must contain a valid CPF.";
    public static final String TELEPHONE = "This field must contain a telephone number.";
    public static final String NAME = "This field is for a name, so it supports only spaces and alphabetic characters.";
    public static final String MAX_10 = "This field must contain a maximum of 10 characters.";
    public static final String MAX_20 = "This field must contain a maximum of 20 characters.";
    public static final String MAX_50 = "This field must contain a maximum of 50 characters.";
    public static final String NOT_BLANK = "This field can't be blank.";
    public static final String NOT_NULL = "This field can't be null.";
    public static final String NOT_EMPTY = "This field needs at least one element.";
    public static final String POSITIVE = "This field must contain a positive value.";
    public static final String ENTITY_NOT_FOUND = "Can't found in the database.";
    public static final String ALREADY_DISABLED = "This element is already disabled.";
    public static final String ORDER_DELIVERED = "This order has already been delivered and cannot be modified.";
    public static final String ORDER_CANCELED = "This order was been canceled.";
}




