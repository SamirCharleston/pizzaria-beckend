package com.example.pizzariabackend.pizzariabackend.services;

import com.example.pizzariabackend.pizzariabackend.dtos.in.flavorDtos.FlavorIdDTO;
import com.example.pizzariabackend.pizzariabackend.dtos.in.flavorDtos.FlavorInDTO;
import com.example.pizzariabackend.pizzariabackend.dtos.in.flavorDtos.FlavorUpdateDTO;
import com.example.pizzariabackend.pizzariabackend.dtos.out.flavorDtos.FlavorOutDTO;
import com.example.pizzariabackend.pizzariabackend.entities.Flavor;
import com.example.pizzariabackend.pizzariabackend.repositories.FlavorRepository;
import com.example.pizzariabackend.pizzariabackend.config.abstractClasses.AbstractService;

public class FlavorService extends AbstractService<
        FlavorRepository,
        FlavorIdDTO,
        FlavorInDTO,
        FlavorUpdateDTO,
        FlavorOutDTO,
        Flavor> {
}
