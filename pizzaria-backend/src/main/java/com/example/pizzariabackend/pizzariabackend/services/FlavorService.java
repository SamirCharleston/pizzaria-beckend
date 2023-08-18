package com.example.pizzariabackend.pizzariabackend.services;

import com.example.pizzariabackend.pizzariabackend.config.messageHandling.ErrorMessages;
import com.example.pizzariabackend.pizzariabackend.config.messageHandling.SuccessMessages;
import com.example.pizzariabackend.pizzariabackend.dtos.in.flavorDtos.FlavorInDTO;
import com.example.pizzariabackend.pizzariabackend.dtos.in.flavorDtos.FlavorUpdateDTO;
import com.example.pizzariabackend.pizzariabackend.dtos.out.flavorDtos.FlavorOutDTO;
import com.example.pizzariabackend.pizzariabackend.entities.Flavor;
import com.example.pizzariabackend.pizzariabackend.repositories.FlavorRepository;
import jakarta.persistence.EntityNotFoundException;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class FlavorService{
    @Autowired
    private FlavorRepository repository;
    @Autowired
    private ModelMapper modelMapper;
    public FlavorOutDTO findById(Long id){
        Flavor flavorDatabase = repository.findById(id).orElseThrow(() -> {
            throw new EntityNotFoundException(ErrorMessages.ENTITY_NOT_FOUND);
        });
        return modelMapper.map(flavorDatabase, FlavorOutDTO.class);
    }
    public List<FlavorOutDTO> findAll(){
        List<Flavor> flavors = repository.findAll();
        if(flavors.isEmpty())
            throw new EntityNotFoundException(ErrorMessages.ENTITY_NOT_FOUND);
        List<FlavorOutDTO> flavorOutDTOS = new ArrayList<>();
        for(Flavor i : flavors){
            flavorOutDTOS.add(modelMapper.map(i, FlavorOutDTO.class));
        }
        return flavorOutDTOS;
    }
    public String register(FlavorInDTO request){
        Flavor flavorToDatabase = modelMapper.map(request, Flavor.class);
        repository.save(flavorToDatabase);
        return SuccessMessages.SAVED;
    }
    public String update(FlavorUpdateDTO request){
        Flavor flavorToDatabase = modelMapper.map(request, Flavor.class);
        repository.save(flavorToDatabase);
        return SuccessMessages.UPDATED;
    }
    public String delete(Long id){
        if(!repository.existsById(id))
            throw new EntityNotFoundException(ErrorMessages.ENTITY_NOT_FOUND);
        Flavor flavorDataBase = repository.getById(id);
        if(/*repository.isLinked(flavorDataBase) && */flavorDataBase.isStatus()) {
            repository.getById(id).setStatus(false);
            return SuccessMessages.DISABLED;
        } else if(!flavorDataBase.isStatus()){
            return ErrorMessages.ALREADY_DISABLED;
        }
        repository.deleteById(id);
        return SuccessMessages.DELETED;
    }
}
