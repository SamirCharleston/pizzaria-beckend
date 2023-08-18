package com.example.pizzariabackend.pizzariabackend.dtos.in.addressDtos;

import com.example.pizzariabackend.pizzariabackend.config.messageHandling.ErrorMessages;
import com.example.pizzariabackend.pizzariabackend.config.validation.RegexValidation;
import com.example.pizzariabackend.pizzariabackend.abstractClasses.abstractDtos.AbstractUpdateDTO;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;

public class AddressUpdateDTO extends AbstractUpdateDTO {
    @NotBlank(message = ErrorMessages.NOT_BLANK)
    @NotNull(message = ErrorMessages.NOT_NULL)
    @Max(value = 50, message = ErrorMessages.MAX_50)
    @Pattern(regexp = RegexValidation.SPACE_AND_LETTERS, message = ErrorMessages.SPACE_AND_LETTERS)
    private String street;
    @Max(value = 10, message = ErrorMessages.MAX_10)
    @NotBlank(message = ErrorMessages.NOT_BLANK)
    @NotNull(message = ErrorMessages.NOT_NULL)
    @Pattern(regexp = RegexValidation.ONLY_NUMBERS, message = ErrorMessages.ONLY_NUMBERS)
    private String number;
    @Max(value = 50, message = ErrorMessages.MAX_50)
    @NotBlank(message = ErrorMessages.NOT_BLANK)
    @NotNull(message = ErrorMessages.NOT_NULL)
    @Pattern(regexp = RegexValidation.SPACE_AND_LETTERS, message = ErrorMessages.SPACE_AND_LETTERS)
    private String neighborhood;
}
