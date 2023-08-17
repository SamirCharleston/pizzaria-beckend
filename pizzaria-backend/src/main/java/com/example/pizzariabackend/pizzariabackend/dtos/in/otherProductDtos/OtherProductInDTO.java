package com.example.pizzariabackend.pizzariabackend.dtos.in.otherProductDtos;

import com.example.pizzariabackend.pizzariabackend.config.messageHandling.ErrorMessages;
import com.example.pizzariabackend.pizzariabackend.config.validation.RegexValidation;
import com.example.pizzariabackend.pizzariabackend.config.abstractClasses.abstractDtos.AbstractInDTO;
import jakarta.validation.constraints.*;

import java.math.BigDecimal;

public class OtherProductInDTO extends AbstractInDTO {
    @Pattern(regexp = RegexValidation.NAME, message = ErrorMessages.NAME)
    private String name;
    @NotNull(message = ErrorMessages.NOT_NULL)
    @Positive(message = ErrorMessages.POSITIVE)
    private BigDecimal price;
    @Max(value = 20, message = ErrorMessages.MAX_20)
    @NotNull(message = ErrorMessages.NOT_NULL)
    @NotBlank(message = ErrorMessages.NOT_BLANK)
    private String kind;
}
