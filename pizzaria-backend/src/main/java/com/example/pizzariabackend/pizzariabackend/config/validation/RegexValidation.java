package com.example.pizzariabackend.pizzariabackend.config.validation;

public abstract class RegexValidation {
    public static final String NAME = "^[a-zA-Z\\s]{1,50}$";
    public static final String ONLY_LETTERS = "^[a-zA-Z]*$";
    public static final String LETTERS_SPACES_NUMBERS = "^[a-zA-Z\\s0-9]*$";
    public static final String SPACE_AND_LETTERS = "^[a-zA-Z\\s]*$";
    public static final String ONLY_NUMBERS = "^[0-9]*$";
    public static final String TELEPHONE = "^\\([0-9]{2}\\)[0-9]{9}";
}
