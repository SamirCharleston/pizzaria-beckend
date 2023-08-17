package com.example.pizzariabackend.pizzariabackend.dtos.in.orderDtos;

import com.example.pizzariabackend.pizzariabackend.entities.Collaborator;
import com.example.pizzariabackend.pizzariabackend.entities.Customer;
import com.example.pizzariabackend.pizzariabackend.entities.OtherProduct;
import com.example.pizzariabackend.pizzariabackend.entities.Pizza;
import com.example.pizzariabackend.pizzariabackend.config.messageHandling.ErrorMessages;
import com.example.pizzariabackend.pizzariabackend.config.abstractClasses.abstractDtos.AbstractUpdateDTO;
import jakarta.validation.constraints.NotNull;

import java.util.List;

public class OrderUpdateDTO extends AbstractUpdateDTO {
    @NotNull(message = ErrorMessages.NOT_NULL)
    private List<Collaborator> collaborators;
    private List<OtherProduct> otherProducts;
    @NotNull(message = ErrorMessages.NOT_NULL)
    private Customer customer;
    @NotNull(message = ErrorMessages.NOT_NULL)
    private List<Pizza> pizzas;
    private boolean delivered;
}
