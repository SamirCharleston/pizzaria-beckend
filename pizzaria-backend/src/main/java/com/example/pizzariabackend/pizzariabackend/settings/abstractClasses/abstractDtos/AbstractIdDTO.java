package com.example.pizzariabackend.pizzariabackend.settings.abstractClasses.abstractDtos;

import com.example.pizzariabackend.pizzariabackend.settings.Config;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import lombok.Getter;

@Getter
public class AbstractIdDTO extends Config {
    @NotNull(message = ERROR_MESSAGES.NOT_NULL)
    @NotBlank(message = ERROR_MESSAGES.NOT_BLANK)
    @Positive(message = ERROR_MESSAGES.POSITIVE)
    private Long id;
}
