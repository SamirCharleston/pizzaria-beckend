package com.example.pizzariabackend.pizzariabackend.settings;

public class RegularExpressions extends ErrorMessages {
    protected final String nameRegex = "^[a-zA-Z\s]{50}$";
    protected final String onlyLettersRegex = "^[a-zA-Z]*$";
    protected final String spaceAndLettersRegex = "^[a-zA-Z\s]*$";
    protected final String onlyNumbersRegex = "^[0-9]$*";
}
