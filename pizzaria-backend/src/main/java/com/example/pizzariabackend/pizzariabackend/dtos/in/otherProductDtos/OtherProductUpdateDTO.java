package com.example.pizzariabackend.pizzariabackend.dtos.in.otherProductDtos;

import com.example.pizzariabackend.pizzariabackend.settings.ErrorMessages;
import com.example.pizzariabackend.pizzariabackend.settings.RegularExpressions;
import com.example.pizzariabackend.pizzariabackend.settings.abstractClasses.abstractDtos.AbstractUpdateDTO;
import jakarta.validation.constraints.*;

import java.math.BigDecimal;

public class OtherProductUpdateDTO extends AbstractUpdateDTO {
    @Pattern(regexp = RegularExpressions.NAME, message = ErrorMessages.NAME)
    private String name;
    @NotNull(message = ErrorMessages.NOT_NULL)
    @Positive(message = ErrorMessages.POSITIVE)
    private BigDecimal price;
    @Max(value = 20, message = ErrorMessages.MAX_20)
    @NotNull(message = ErrorMessages.NOT_NULL)
    @NotBlank(message = ErrorMessages.NOT_BLANK)
    private String kind;
}