package com.example.pizzariabackend.pizzariabackend.services;

import com.example.pizzariabackend.pizzariabackend.config.messageHandling.ErrorMessages;
import com.example.pizzariabackend.pizzariabackend.config.messageHandling.SuccessMessages;
import com.example.pizzariabackend.pizzariabackend.dtos.in.collaboratorDtos.CollaboratorInDTO;
import com.example.pizzariabackend.pizzariabackend.dtos.in.collaboratorDtos.CollaboratorUpdateDTO;
import com.example.pizzariabackend.pizzariabackend.dtos.out.collaboratorDtos.CollaboratorOutDTO;
import com.example.pizzariabackend.pizzariabackend.entities.Collaborator;
import com.example.pizzariabackend.pizzariabackend.repositories.CollaboratorRepository;
import jakarta.persistence.EntityNotFoundException;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class CollaboratorService {
    @Autowired
    private CollaboratorRepository repository;
    @Autowired
    private ModelMapper modelMapper;
    public CollaboratorOutDTO findById(Long id){
        Collaborator collaboratorDatabase = repository.findById(id).orElseThrow(() -> {
            throw new EntityNotFoundException(ErrorMessages.ENTITY_NOT_FOUND);
        });
        return modelMapper.map(collaboratorDatabase, CollaboratorOutDTO.class);
    }
    public List<CollaboratorOutDTO> findAll(){
        List<Collaborator> collaborators = repository.findAll();
        if(collaborators.isEmpty())
            throw new EntityNotFoundException(ErrorMessages.ENTITY_NOT_FOUND);
        List<CollaboratorOutDTO> collaboratorOutDTOS = new ArrayList<>();
        for(Collaborator i : collaborators){
            collaboratorOutDTOS.add(modelMapper.map(i, CollaboratorOutDTO.class));
        }
        return collaboratorOutDTOS;
    }
    public String register(CollaboratorInDTO request){
        Collaborator collaboratorToDatabase = modelMapper.map(request, Collaborator.class);
        repository.save(collaboratorToDatabase);
        return SuccessMessages.SAVED;
    }
    public String update(CollaboratorUpdateDTO request){
        Collaborator collaboratorToDatabase = modelMapper.map(request, Collaborator.class);
        repository.save(collaboratorToDatabase);
        return SuccessMessages.UPDATED;
    }
    public String delete(Long id){
        if(!repository.existsById(id))
            throw new EntityNotFoundException(ErrorMessages.ENTITY_NOT_FOUND);
        Collaborator collaboratorDataBase = repository.getById(id);
        if(/*repository.isLinked(collaboratorDataBase) && */collaboratorDataBase.isStatus()) {
            repository.getById(id).setStatus(false);
            return SuccessMessages.DISABLED;
        } else if(!collaboratorDataBase.isStatus()){
            return ErrorMessages.ALREADY_DISABLED;
        }
        repository.deleteById(id);
        return SuccessMessages.DELETED;
    }
}
