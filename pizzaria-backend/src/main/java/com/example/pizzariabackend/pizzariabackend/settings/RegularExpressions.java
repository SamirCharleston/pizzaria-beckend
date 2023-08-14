package com.example.pizzariabackend.pizzariabackend.settings;

public class RegularExpressions {
    public static final String NAME = "^[a-zA-Z\\s]{50}$";
    public static final String ONLY_LETTERS = "^[a-zA-Z]*$";
    public static final String SPACE_AND_LETTERS = "^[a-zA-Z\\s]*$";
    public static final String ONLY_NUMBERS = "^[0-9]*$";
    public static final String TELEPHONE = "^\\([0-9]{2}\\)[0-9]{9}";
}
