package com.example.pizzariabackend.pizzariabackend.dtos.in.flavorDtos;

import com.example.pizzariabackend.pizzariabackend.entities.Ingredient;
import com.example.pizzariabackend.pizzariabackend.config.messageHandling.ErrorMessages;
import com.example.pizzariabackend.pizzariabackend.config.validation.RegexValidation;
import com.example.pizzariabackend.pizzariabackend.config.abstractClasses.abstractDtos.AbstractUpdateDTO;
import jakarta.validation.constraints.*;

import java.util.List;

public class FlavorUpdateDTO extends AbstractUpdateDTO {
    @NotBlank(message = ErrorMessages.NOT_BLANK)
    @NotNull(message = ErrorMessages.NOT_NULL)
    @Max(value = 50, message = ErrorMessages.MAX_50)
    @Pattern(regexp = RegexValidation.NAME, message = ErrorMessages.NAME)
    private String name;
    @NotNull(message = ErrorMessages.NOT_NULL)
    @NotEmpty(message = ErrorMessages.NOT_EMPTY)
    private List<Ingredient> ingredients;
}
