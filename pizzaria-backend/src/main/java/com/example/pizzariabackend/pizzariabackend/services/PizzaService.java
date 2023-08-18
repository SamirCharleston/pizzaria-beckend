package com.example.pizzariabackend.pizzariabackend.services;

import com.example.pizzariabackend.pizzariabackend.config.messageHandling.ErrorMessages;
import com.example.pizzariabackend.pizzariabackend.config.messageHandling.SuccessMessages;
import com.example.pizzariabackend.pizzariabackend.dtos.in.pizzaDtos.PizzaInDTO;
import com.example.pizzariabackend.pizzariabackend.dtos.in.pizzaDtos.PizzaUpdateDTO;
import com.example.pizzariabackend.pizzariabackend.dtos.in.pizzaDtos.PizzaIdDTO;
import com.example.pizzariabackend.pizzariabackend.dtos.in.pizzaDtos.PizzaInDTO;
import com.example.pizzariabackend.pizzariabackend.dtos.in.pizzaDtos.PizzaUpdateDTO;
import com.example.pizzariabackend.pizzariabackend.dtos.out.pizzaDtos.PizzaOutDTO;
import com.example.pizzariabackend.pizzariabackend.dtos.out.pizzaDtos.PizzaOutDTO;
import com.example.pizzariabackend.pizzariabackend.entities.Pizza;
import com.example.pizzariabackend.pizzariabackend.entities.Pizza;
import com.example.pizzariabackend.pizzariabackend.repositories.PizzaRepository;
import com.example.pizzariabackend.pizzariabackend.repositories.PizzaRepository;
import com.example.pizzariabackend.pizzariabackend.abstractClasses.AbstractService;
import jakarta.persistence.EntityNotFoundException;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class PizzaService{
    @Autowired
    private PizzaRepository repository;
    @Autowired
    private ModelMapper modelMapper;
    public PizzaOutDTO findById(Long id){
        Pizza pizzaDatabase = repository.findById(id).orElseThrow(() -> {
            throw new EntityNotFoundException(ErrorMessages.ENTITY_NOT_FOUND);
        });
        return modelMapper.map(pizzaDatabase, PizzaOutDTO.class);
    }
    public List<PizzaOutDTO> findAll(){
        List<Pizza> pizzas = repository.findAll();
        if(pizzas.isEmpty())
            throw new EntityNotFoundException(ErrorMessages.ENTITY_NOT_FOUND);
        List<PizzaOutDTO> pizzaOutDTOS = new ArrayList<>();
        for(Pizza i : pizzas){
            pizzaOutDTOS.add(modelMapper.map(i, PizzaOutDTO.class));
        }
        return pizzaOutDTOS;
    }
    public String register(PizzaInDTO request){
        Pizza pizzaToDatabase = modelMapper.map(request, Pizza.class);
        repository.save(pizzaToDatabase);
        return SuccessMessages.SAVED;
    }
    public String update(PizzaUpdateDTO request){
        Pizza pizzaToDatabase = modelMapper.map(request, Pizza.class);
        repository.save(pizzaToDatabase);
        return SuccessMessages.UPDATED;
    }
    public String delete(Long id){
        if(!repository.existsById(id))
            throw new EntityNotFoundException(ErrorMessages.ENTITY_NOT_FOUND);
        Pizza pizzaDataBase = repository.getById(id);
        if(/*repository.isLinked(pizzaDataBase) &&*/ pizzaDataBase.isStatus()) {
            repository.getById(id).setStatus(false);
            return SuccessMessages.DISABLED;
        } else if(!pizzaDataBase.isStatus()){
            return ErrorMessages.ALREADY_DISABLED;
        }
        repository.deleteById(id);
        return SuccessMessages.DELETED;
    }
}
