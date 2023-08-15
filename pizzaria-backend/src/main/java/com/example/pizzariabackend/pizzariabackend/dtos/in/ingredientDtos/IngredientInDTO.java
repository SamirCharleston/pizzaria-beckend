package com.example.pizzariabackend.pizzariabackend.dtos.in.ingredientDtos;

import com.example.pizzariabackend.pizzariabackend.settings.ErrorMessages;
import com.example.pizzariabackend.pizzariabackend.settings.RegularExpressions;
import com.example.pizzariabackend.pizzariabackend.settings.abstractClasses.abstractDtos.AbstractInDTO;
import jakarta.validation.constraints.*;

public class IngredientInDTO extends AbstractInDTO {
    @NotBlank(message = ErrorMessages.NOT_BLANK)
    @NotNull(message = ErrorMessages.NOT_NULL)
    @Max(value = 50, message = ErrorMessages.MAX_50)
    @Pattern(regexp = RegularExpressions.NAME, message = ErrorMessages.NAME)
    private String name;
}
