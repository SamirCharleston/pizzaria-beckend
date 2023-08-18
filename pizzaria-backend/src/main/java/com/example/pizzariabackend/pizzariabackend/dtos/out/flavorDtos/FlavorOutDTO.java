package com.example.pizzariabackend.pizzariabackend.dtos.out.flavorDtos;

import com.example.pizzariabackend.pizzariabackend.abstractClasses.abstractDtos.AbstractOutDTO;
import com.example.pizzariabackend.pizzariabackend.entities.Ingredient;
import jakarta.persistence.Column;
import jakarta.persistence.OneToMany;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class FlavorOutDTO{
    private String name;
    private List<Ingredient> ingredients;
}
