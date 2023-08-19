package com.example.pizzariabackend.pizzariabackend.dtos.in.orderDtos;

import com.example.pizzariabackend.pizzariabackend.entities.Collaborator;
import com.example.pizzariabackend.pizzariabackend.entities.Customer;
import com.example.pizzariabackend.pizzariabackend.entities.OtherProduct;
import com.example.pizzariabackend.pizzariabackend.entities.Pizza;
import com.example.pizzariabackend.pizzariabackend.config.messageHandling.ErrorMessages;
import com.example.pizzariabackend.pizzariabackend.abstractClasses.abstractDtos.AbstractUpdateDTO;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

import java.util.List;
@Getter
@Setter
public class OrderUpdateDTO {
    @NotNull(message = ErrorMessages.NOT_NULL)
    private Long id;
    private Collaborator collaborator;
    private List<OtherProduct> otherProducts;
    private Customer customer;
    private List<Pizza> pizzas;
    private boolean delivered;
}
