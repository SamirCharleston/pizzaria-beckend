package com.example.pizzariabackend.pizzariabackend.dtos.out.pizzaDtos;

import com.example.pizzariabackend.pizzariabackend.abstractClasses.abstractDtos.AbstractOutDTO;
import com.example.pizzariabackend.pizzariabackend.entities.Flavor;
import com.example.pizzariabackend.pizzariabackend.entities.Size;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class PizzaOutDTO{
    private int quantity;
    private Size size;
    private List<Flavor> flavors;
}
