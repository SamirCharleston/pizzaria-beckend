package com.example.pizzariabackend.pizzariabackend.dtos.in.orderDtos;

import com.example.pizzariabackend.pizzariabackend.entities.Collaborator;
import com.example.pizzariabackend.pizzariabackend.entities.Customer;
import com.example.pizzariabackend.pizzariabackend.entities.OtherProduct;
import com.example.pizzariabackend.pizzariabackend.entities.Pizza;
import com.example.pizzariabackend.pizzariabackend.settings.ErrorMessages;
import com.example.pizzariabackend.pizzariabackend.settings.abstractClasses.abstractDtos.AbstractInDTO;
import jakarta.validation.constraints.NotNull;

import java.util.List;

public class OrderInDTO extends AbstractInDTO {
    @NotNull(message = ErrorMessages.NOT_NULL)
    private List<Collaborator> collaborators;
    private List<OtherProduct> otherProducts;
    @NotNull(message = ErrorMessages.NOT_NULL)
    private Customer customer;
    @NotNull(message = ErrorMessages.NOT_NULL)
    private List<Pizza> pizzas;
    private boolean delivered;
}
