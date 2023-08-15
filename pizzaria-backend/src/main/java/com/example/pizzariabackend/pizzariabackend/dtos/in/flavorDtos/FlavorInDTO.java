package com.example.pizzariabackend.pizzariabackend.dtos.in.flavorDtos;

import com.example.pizzariabackend.pizzariabackend.entities.Ingredient;
import com.example.pizzariabackend.pizzariabackend.settings.ErrorMessages;
import com.example.pizzariabackend.pizzariabackend.settings.RegularExpressions;
import com.example.pizzariabackend.pizzariabackend.settings.abstractClasses.abstractDtos.AbstractInDTO;
import jakarta.validation.constraints.*;

import java.util.List;

public class FlavorInDTO extends AbstractInDTO {
    @NotBlank(message = ErrorMessages.NOT_BLANK)
    @NotNull(message = ErrorMessages.NOT_NULL)
    @Max(value = 50, message = ErrorMessages.MAX_50)
    @Pattern(regexp = RegularExpressions.NAME, message = ErrorMessages.NAME)
    private String name;
    @NotNull(message = ErrorMessages.NOT_NULL)
    @NotEmpty(message = ErrorMessages.NOT_EMPTY)
    private List<Ingredient> ingredients;
}
