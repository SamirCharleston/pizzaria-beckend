package com.example.pizzariabackend.pizzariabackend.dtos.in.otherProductDtos;

import com.example.pizzariabackend.pizzariabackend.config.messageHandling.ErrorMessages;
import com.example.pizzariabackend.pizzariabackend.config.validation.RegexValidation;
import com.example.pizzariabackend.pizzariabackend.abstractClasses.abstractDtos.AbstractUpdateDTO;
import jakarta.validation.constraints.*;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;
@Getter
@Setter
public class OtherProductUpdateDTO {
    @NotNull(message = ErrorMessages.NOT_NULL)
    private Long id;
    @Pattern(regexp = RegexValidation.NAME, message = ErrorMessages.NAME)
    private String name;
    @Positive(message = ErrorMessages.POSITIVE)
    private BigDecimal price;
    @Size(max = 20, message = ErrorMessages.MAX_20)
    @NotBlank(message = ErrorMessages.NOT_BLANK)
    private String kind;
}
