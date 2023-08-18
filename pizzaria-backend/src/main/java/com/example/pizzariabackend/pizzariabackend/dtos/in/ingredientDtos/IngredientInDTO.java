package com.example.pizzariabackend.pizzariabackend.dtos.in.ingredientDtos;

import com.example.pizzariabackend.pizzariabackend.config.messageHandling.ErrorMessages;
import com.example.pizzariabackend.pizzariabackend.config.validation.RegexValidation;
import com.example.pizzariabackend.pizzariabackend.abstractClasses.abstractDtos.AbstractInDTO;
import jakarta.validation.constraints.*;

public class IngredientInDTO extends AbstractInDTO {
    @NotBlank(message = ErrorMessages.NOT_BLANK)
    @NotNull(message = ErrorMessages.NOT_NULL)
    @Max(value = 50, message = ErrorMessages.MAX_50)
    @Pattern(regexp = RegexValidation.NAME, message = ErrorMessages.NAME)
    private String name;
}
