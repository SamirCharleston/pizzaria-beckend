package com.example.pizzariabackend.pizzariabackend.services;

import com.example.pizzariabackend.pizzariabackend.config.messageHandling.ErrorMessages;
import com.example.pizzariabackend.pizzariabackend.config.messageHandling.SuccessMessages;
import com.example.pizzariabackend.pizzariabackend.dtos.in.otherProductDtos.OtherProductInDTO;
import com.example.pizzariabackend.pizzariabackend.dtos.in.otherProductDtos.OtherProductUpdateDTO;
import com.example.pizzariabackend.pizzariabackend.dtos.out.otherProductDtos.OtherProductOutDTO;
import com.example.pizzariabackend.pizzariabackend.entities.OtherProduct;
import com.example.pizzariabackend.pizzariabackend.repositories.OtherProductRepository;
import jakarta.persistence.EntityNotFoundException;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class OtherProductService {
    @Autowired
    private OtherProductRepository repository;
    @Autowired
    private ModelMapper modelMapper;
    public OtherProductOutDTO findById(Long id){
        OtherProduct otherProductDatabase = repository.findById(id).orElseThrow(() -> {
            throw new EntityNotFoundException(ErrorMessages.ENTITY_NOT_FOUND);
        });
        return modelMapper.map(otherProductDatabase, OtherProductOutDTO.class);
    }
    public List<OtherProductOutDTO> findAll(){
        List<OtherProduct> otherProducts = repository.findAll();
        if(otherProducts.isEmpty())
            throw new EntityNotFoundException(ErrorMessages.ENTITY_NOT_FOUND);
        List<OtherProductOutDTO> otherProductOutDTOS = new ArrayList<>();
        for(OtherProduct i : otherProducts){
            otherProductOutDTOS.add(modelMapper.map(i, OtherProductOutDTO.class));
        }
        return otherProductOutDTOS;
    }
    public String register(OtherProductInDTO request){
        OtherProduct otherProductToDatabase = modelMapper.map(request, OtherProduct.class);
        repository.save(otherProductToDatabase);
        return SuccessMessages.SAVED;
    }
    public String update(OtherProductUpdateDTO request){
        OtherProduct otherProductToDatabase = modelMapper.map(request, OtherProduct.class);
        repository.save(otherProductToDatabase);
        return SuccessMessages.UPDATED;
    }
    public String delete(Long id){
        if(!repository.existsById(id))
            throw new EntityNotFoundException(ErrorMessages.ENTITY_NOT_FOUND);
        OtherProduct otherProductDataBase = repository.getById(id);
        if(/*repository.isLinked(otherProductDataBase) &&*/ otherProductDataBase.isStatus()) {
            repository.getById(id).setStatus(false);
            return SuccessMessages.DISABLED;
        } else if(!otherProductDataBase.isStatus()){
            return ErrorMessages.ALREADY_DISABLED;
        }
        repository.deleteById(id);
        return SuccessMessages.DELETED;
    }
}
