package com.example.pizzariabackend.pizzariabackend.services;

import com.example.pizzariabackend.pizzariabackend.config.messageHandling.ErrorMessages;
import com.example.pizzariabackend.pizzariabackend.config.messageHandling.SuccessMessages;
import com.example.pizzariabackend.pizzariabackend.dtos.in.ingredientDtos.IngredientInDTO;
import com.example.pizzariabackend.pizzariabackend.dtos.in.ingredientDtos.IngredientUpdateDTO;
import com.example.pizzariabackend.pizzariabackend.dtos.out.ingredientDtos.IngredientOutDTO;
import com.example.pizzariabackend.pizzariabackend.entities.Flavor;
import com.example.pizzariabackend.pizzariabackend.entities.Ingredient;
import com.example.pizzariabackend.pizzariabackend.repositories.IngredientRepository;
import jakarta.persistence.EntityNotFoundException;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class IngredientService{
    @Autowired
    private IngredientRepository repository;
    @Autowired
    private ModelMapper modelMapper;
    public IngredientOutDTO findById(Long id){
        Ingredient ingredientDatabase = repository.findById(id).orElseThrow(() -> {
            throw new EntityNotFoundException(ErrorMessages.ENTITY_NOT_FOUND);
        });
        return modelMapper.map(ingredientDatabase, IngredientOutDTO.class);
    }
    public List<IngredientOutDTO> findAll(){
        List<Ingredient> ingredients = repository.findAll();
        if(ingredients.isEmpty())
            throw new EntityNotFoundException(ErrorMessages.ENTITY_NOT_FOUND);
        List<IngredientOutDTO> ingredientOutDTOS = new ArrayList<>();
        for(Ingredient i : ingredients){
            ingredientOutDTOS.add(modelMapper.map(i, IngredientOutDTO.class));
        }
        return ingredientOutDTOS;
    }
    public String register(IngredientInDTO request){
        Ingredient ingredientToDatabase = modelMapper.map(request, Ingredient.class);
        repository.save(ingredientToDatabase);
        return SuccessMessages.SAVED;
    }
    public String update(IngredientUpdateDTO request){
        if(!repository.existsById(request.getId()))
            throw new EntityNotFoundException(ErrorMessages.ENTITY_NOT_FOUND);
        Ingredient ingredientToDatabase = repository.getById(request.getId());
        //Put the variation below this line
        if(request.getName() != null && !request.getName().isEmpty())
            ingredientToDatabase.setName(request.getName());
        //Put the variation above this line
        repository.save(ingredientToDatabase);
        return SuccessMessages.UPDATED;
    }
    public String delete(Long id){
        if(!repository.existsById(id))
            throw new EntityNotFoundException(ErrorMessages.ENTITY_NOT_FOUND);
        Ingredient ingredientDataBase = repository.getById(id);
        if(repository.isLinked(ingredientDataBase) && ingredientDataBase.isStatus()) {
            repository.getById(id).setStatus(false);
            return SuccessMessages.DISABLED;
        } else if(!ingredientDataBase.isStatus()){
            return ErrorMessages.ALREADY_DISABLED;
        }
        repository.deleteById(id);
        return SuccessMessages.DELETED;
    }
}
