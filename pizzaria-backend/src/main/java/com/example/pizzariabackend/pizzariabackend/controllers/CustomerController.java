package com.example.pizzariabackend.pizzariabackend.controllers;

import com.example.pizzariabackend.pizzariabackend.dtos.request.customerDtos.CustomerIdDTO;
import com.example.pizzariabackend.pizzariabackend.dtos.request.customerDtos.CustomerInDTO;
import com.example.pizzariabackend.pizzariabackend.dtos.request.customerDtos.CustomerOutDTO;
import com.example.pizzariabackend.pizzariabackend.dtos.request.customerDtos.CustomerUpdateDTO;
import com.example.pizzariabackend.pizzariabackend.settings.abstractClasses.AbstractController;
import com.example.pizzariabackend.pizzariabackend.settings.abstractClasses.AbstractService;

public class CustomerController extends AbstractController<AbstractService,
        CustomerIdDTO,
        CustomerInDTO,
        CustomerUpdateDTO,
        CustomerOutDTO> {
}
