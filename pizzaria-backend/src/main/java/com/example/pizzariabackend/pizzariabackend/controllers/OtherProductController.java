package com.example.pizzariabackend.pizzariabackend.controllers;

import com.example.pizzariabackend.pizzariabackend.dtos.in.otherProductDtos.OtherProductIdDTO;
import com.example.pizzariabackend.pizzariabackend.dtos.in.otherProductDtos.OtherProductInDTO;
import com.example.pizzariabackend.pizzariabackend.dtos.in.otherProductDtos.OtherProductUpdateDTO;
import com.example.pizzariabackend.pizzariabackend.dtos.out.otherProductDtos.OtherProductOutDTO;
import com.example.pizzariabackend.pizzariabackend.config.abstractClasses.AbstractController;
import com.example.pizzariabackend.pizzariabackend.config.abstractClasses.AbstractService;

public class OtherProductController extends AbstractController<AbstractService,
        OtherProductIdDTO,
        OtherProductInDTO,
        OtherProductUpdateDTO,
        OtherProductOutDTO> {
}
