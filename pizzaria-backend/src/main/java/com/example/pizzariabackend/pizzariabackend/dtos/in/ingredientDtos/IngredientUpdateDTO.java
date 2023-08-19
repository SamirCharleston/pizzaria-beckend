package com.example.pizzariabackend.pizzariabackend.dtos.in.ingredientDtos;

import com.example.pizzariabackend.pizzariabackend.config.messageHandling.ErrorMessages;
import com.example.pizzariabackend.pizzariabackend.config.validation.RegexValidation;
import com.example.pizzariabackend.pizzariabackend.abstractClasses.abstractDtos.AbstractUpdateDTO;
import jakarta.validation.constraints.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class IngredientUpdateDTO {
    @NotNull(message = ErrorMessages.NOT_NULL)
    private Long id;
    @NotBlank(message = ErrorMessages.NOT_BLANK)
    @Size(max = 50, message = ErrorMessages.MAX_50)
    @Pattern(regexp = RegexValidation.NAME, message = ErrorMessages.NAME)
    private String name;
}
