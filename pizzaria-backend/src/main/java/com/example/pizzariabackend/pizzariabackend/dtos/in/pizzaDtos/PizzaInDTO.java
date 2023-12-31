package com.example.pizzariabackend.pizzariabackend.dtos.in.pizzaDtos;

import com.example.pizzariabackend.pizzariabackend.entities.Flavor;
import com.example.pizzariabackend.pizzariabackend.entities.Size;
import com.example.pizzariabackend.pizzariabackend.config.messageHandling.ErrorMessages;
import com.example.pizzariabackend.pizzariabackend.abstractClasses.abstractDtos.AbstractInDTO;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.validation.constraints.*;
import lombok.Getter;
import lombok.Setter;

import java.util.List;
@Getter
@Setter
public class PizzaInDTO extends AbstractInDTO {
    @Positive(message = ErrorMessages.POSITIVE)
    private int quantity;
    @NotNull(message = ErrorMessages.NOT_NULL)
    @Enumerated(EnumType.STRING)
    private Size size;
    @NotNull(message = ErrorMessages.NOT_NULL)
    @NotEmpty(message = ErrorMessages.NOT_EMPTY)
    private List<Flavor> flavors;
}
