package com.example.pizzariabackend.pizzariabackend.dtos.out.orderDtos;

import com.example.pizzariabackend.pizzariabackend.abstractClasses.abstractDtos.AbstractOutDTO;
import com.example.pizzariabackend.pizzariabackend.entities.Collaborator;
import com.example.pizzariabackend.pizzariabackend.entities.Customer;
import com.example.pizzariabackend.pizzariabackend.entities.OtherProduct;
import com.example.pizzariabackend.pizzariabackend.entities.Pizza;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class OrderOutDTO{
    private List<Collaborator> collaborators;
    private List<OtherProduct> otherProducts;
    private Customer customer;
    private List<Pizza> pizzas;
    private boolean delivered;
}
