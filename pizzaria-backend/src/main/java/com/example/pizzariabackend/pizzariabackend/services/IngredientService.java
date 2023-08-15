package com.example.pizzariabackend.pizzariabackend.services;

import com.example.pizzariabackend.pizzariabackend.dtos.in.ingredientDtos.IngredientIdDTO;
import com.example.pizzariabackend.pizzariabackend.dtos.in.ingredientDtos.IngredientInDTO;
import com.example.pizzariabackend.pizzariabackend.dtos.in.ingredientDtos.IngredientUpdateDTO;
import com.example.pizzariabackend.pizzariabackend.dtos.out.ingredientDtos.IngredientOutDTO;
import com.example.pizzariabackend.pizzariabackend.entities.Ingredient;
import com.example.pizzariabackend.pizzariabackend.repositories.IngredientRepository;
import com.example.pizzariabackend.pizzariabackend.settings.abstractClasses.AbstractService;

public class IngredientService extends AbstractService<
        IngredientRepository,
        IngredientIdDTO,
        IngredientInDTO,
        IngredientUpdateDTO,
        IngredientOutDTO,
        Ingredient>{
}
