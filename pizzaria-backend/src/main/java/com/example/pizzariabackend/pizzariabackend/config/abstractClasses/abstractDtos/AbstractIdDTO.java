package com.example.pizzariabackend.pizzariabackend.config.abstractClasses.abstractDtos;

import com.example.pizzariabackend.pizzariabackend.config.messageHandling.ErrorMessages;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import lombok.Getter;

@Getter
public class AbstractIdDTO {
    @NotNull(message = ErrorMessages.NOT_NULL)
    @NotBlank(message = ErrorMessages.NOT_BLANK)
    @Positive(message = ErrorMessages.POSITIVE)
    private Long id;
}
