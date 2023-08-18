package com.example.pizzariabackend.pizzariabackend.controllers;

import com.example.pizzariabackend.pizzariabackend.dtos.in.customerDtos.CustomerIdDTO;
import com.example.pizzariabackend.pizzariabackend.dtos.in.customerDtos.CustomerInDTO;
import com.example.pizzariabackend.pizzariabackend.dtos.in.customerDtos.CustomerUpdateDTO;
import com.example.pizzariabackend.pizzariabackend.dtos.out.customerDtos.CustomerOutDTO;
import com.example.pizzariabackend.pizzariabackend.abstractClasses.AbstractController;
import com.example.pizzariabackend.pizzariabackend.abstractClasses.AbstractService;

public class CustomerController extends AbstractController<AbstractService,
        CustomerIdDTO,
        CustomerInDTO,
        CustomerUpdateDTO,
        CustomerOutDTO>{
}
