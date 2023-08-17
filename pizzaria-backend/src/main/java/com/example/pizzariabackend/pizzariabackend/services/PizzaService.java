package com.example.pizzariabackend.pizzariabackend.services;

import com.example.pizzariabackend.pizzariabackend.dtos.in.pizzaDtos.PizzaIdDTO;
import com.example.pizzariabackend.pizzariabackend.dtos.in.pizzaDtos.PizzaInDTO;
import com.example.pizzariabackend.pizzariabackend.dtos.in.pizzaDtos.PizzaUpdateDTO;
import com.example.pizzariabackend.pizzariabackend.dtos.out.pizzaDtos.PizzaOutDTO;
import com.example.pizzariabackend.pizzariabackend.entities.Pizza;
import com.example.pizzariabackend.pizzariabackend.repositories.PizzaRepository;
import com.example.pizzariabackend.pizzariabackend.config.abstractClasses.AbstractService;

public class PizzaService extends AbstractService<
        PizzaRepository,
        PizzaIdDTO,
        PizzaInDTO,
        PizzaUpdateDTO,
        PizzaOutDTO,
        Pizza>{
}
