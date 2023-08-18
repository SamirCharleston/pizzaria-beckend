package com.example.pizzariabackend.pizzariabackend.controllers;

import com.example.pizzariabackend.pizzariabackend.dtos.in.flavorDtos.FlavorIdDTO;
import com.example.pizzariabackend.pizzariabackend.dtos.in.flavorDtos.FlavorInDTO;
import com.example.pizzariabackend.pizzariabackend.dtos.in.flavorDtos.FlavorUpdateDTO;
import com.example.pizzariabackend.pizzariabackend.dtos.out.flavorDtos.FlavorOutDTO;
import com.example.pizzariabackend.pizzariabackend.abstractClasses.AbstractController;
import com.example.pizzariabackend.pizzariabackend.abstractClasses.AbstractService;

public class FlavorController extends AbstractController<AbstractService,
        FlavorIdDTO,
        FlavorInDTO,
        FlavorUpdateDTO,
        FlavorOutDTO> {
}
