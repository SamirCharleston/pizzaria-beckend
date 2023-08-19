package com.example.pizzariabackend.pizzariabackend.dtos.in.pizzaDtos;

import com.example.pizzariabackend.pizzariabackend.entities.Flavor;
import com.example.pizzariabackend.pizzariabackend.entities.Size;
import com.example.pizzariabackend.pizzariabackend.config.messageHandling.ErrorMessages;
import com.example.pizzariabackend.pizzariabackend.abstractClasses.abstractDtos.AbstractUpdateDTO;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.validation.constraints.*;
import lombok.Getter;
import lombok.Setter;

import java.util.List;
@Getter @Setter
public class PizzaUpdateDTO {
    @NotNull(message = ErrorMessages.NOT_NULL)
    private Long id;
    @Positive(message = ErrorMessages.POSITIVE)
    private int quantity;
    @Enumerated(EnumType.STRING)
    private Size size;
    private List<Flavor> flavors;
}
