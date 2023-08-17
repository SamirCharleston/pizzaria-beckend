package com.example.pizzariabackend.pizzariabackend.controllers;

import com.example.pizzariabackend.pizzariabackend.dtos.in.collaboratorDtos.CollaboratorIdDTO;
import com.example.pizzariabackend.pizzariabackend.dtos.in.collaboratorDtos.CollaboratorInDTO;
import com.example.pizzariabackend.pizzariabackend.dtos.in.collaboratorDtos.CollaboratorUpdateDTO;
import com.example.pizzariabackend.pizzariabackend.dtos.out.collaboratorDtos.CollaboratorOutDTO;
import com.example.pizzariabackend.pizzariabackend.config.abstractClasses.AbstractController;
import com.example.pizzariabackend.pizzariabackend.config.abstractClasses.AbstractService;

public class CollaboratorController extends AbstractController<AbstractService,
        CollaboratorIdDTO,
        CollaboratorInDTO,
        CollaboratorUpdateDTO,
        CollaboratorOutDTO> {
}
