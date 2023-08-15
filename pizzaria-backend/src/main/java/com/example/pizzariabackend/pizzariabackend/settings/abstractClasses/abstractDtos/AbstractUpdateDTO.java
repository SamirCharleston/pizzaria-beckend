package com.example.pizzariabackend.pizzariabackend.settings.abstractClasses.abstractDtos;

import com.example.pizzariabackend.pizzariabackend.settings.Config;
import com.example.pizzariabackend.pizzariabackend.settings.ErrorMessages;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import lombok.Getter;

@Getter
public class AbstractUpdateDTO extends Config {
    @NotNull(message = ErrorMessages.NOT_NULL)
    @NotBlank(message = ErrorMessages.NOT_BLANK)
    @Positive(message = ErrorMessages.POSITIVE)
    private Long id;
}
