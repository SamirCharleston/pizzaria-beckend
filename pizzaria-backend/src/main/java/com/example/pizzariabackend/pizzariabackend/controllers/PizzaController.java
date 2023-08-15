package com.example.pizzariabackend.pizzariabackend.controllers;

import com.example.pizzariabackend.pizzariabackend.dtos.in.otherProductDtos.OtherProductIdDTO;
import com.example.pizzariabackend.pizzariabackend.dtos.in.otherProductDtos.OtherProductInDTO;
import com.example.pizzariabackend.pizzariabackend.dtos.in.otherProductDtos.OtherProductUpdateDTO;
import com.example.pizzariabackend.pizzariabackend.dtos.in.pizzaDtos.PizzaIdDTO;
import com.example.pizzariabackend.pizzariabackend.dtos.in.pizzaDtos.PizzaInDTO;
import com.example.pizzariabackend.pizzariabackend.dtos.in.pizzaDtos.PizzaUpdateDTO;
import com.example.pizzariabackend.pizzariabackend.dtos.out.otherProductDtos.OtherProductOutDTO;
import com.example.pizzariabackend.pizzariabackend.dtos.out.pizzaDtos.PizzaOutDTO;
import com.example.pizzariabackend.pizzariabackend.settings.abstractClasses.AbstractController;
import com.example.pizzariabackend.pizzariabackend.settings.abstractClasses.AbstractService;

public class PizzaController extends AbstractController<
        AbstractService,
        PizzaIdDTO,
        PizzaInDTO,
        PizzaUpdateDTO,
        PizzaOutDTO> {
}