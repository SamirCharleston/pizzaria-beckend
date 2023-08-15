package com.example.pizzariabackend.pizzariabackend.services;

import com.example.pizzariabackend.pizzariabackend.dtos.in.collaboratorDtos.CollaboratorIdDTO;
import com.example.pizzariabackend.pizzariabackend.dtos.in.collaboratorDtos.CollaboratorInDTO;
import com.example.pizzariabackend.pizzariabackend.dtos.in.collaboratorDtos.CollaboratorUpdateDTO;
import com.example.pizzariabackend.pizzariabackend.dtos.out.collaboratorDtos.CollaboratorOutDTO;
import com.example.pizzariabackend.pizzariabackend.entities.Collaborator;
import com.example.pizzariabackend.pizzariabackend.repositories.CollaboratorRepository;
import com.example.pizzariabackend.pizzariabackend.settings.abstractClasses.AbstractService;
import org.springframework.stereotype.Service;

@Service
public class CollaboratorService extends AbstractService<
        CollaboratorRepository,
        CollaboratorIdDTO,
        CollaboratorInDTO,
        CollaboratorUpdateDTO,
        CollaboratorOutDTO,
        Collaborator>{
}
