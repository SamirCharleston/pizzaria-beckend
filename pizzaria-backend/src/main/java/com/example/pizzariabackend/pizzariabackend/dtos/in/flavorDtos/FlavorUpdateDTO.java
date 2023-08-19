package com.example.pizzariabackend.pizzariabackend.dtos.in.flavorDtos;

import com.example.pizzariabackend.pizzariabackend.entities.Ingredient;
import com.example.pizzariabackend.pizzariabackend.config.messageHandling.ErrorMessages;
import com.example.pizzariabackend.pizzariabackend.config.validation.RegexValidation;
import com.example.pizzariabackend.pizzariabackend.abstractClasses.abstractDtos.AbstractUpdateDTO;
import jakarta.validation.constraints.*;
import lombok.Getter;
import lombok.Setter;

import java.util.List;
@Getter
@Setter
public class FlavorUpdateDTO {
    @NotNull(message = ErrorMessages.NOT_NULL)
    private Long id;
    @NotBlank(message = ErrorMessages.NOT_BLANK)
    @Size(max = 50, message = ErrorMessages.MAX_50)
    @Pattern(regexp = RegexValidation.NAME, message = ErrorMessages.NAME)
    private String name;
    private List<Ingredient> ingredients;
}
