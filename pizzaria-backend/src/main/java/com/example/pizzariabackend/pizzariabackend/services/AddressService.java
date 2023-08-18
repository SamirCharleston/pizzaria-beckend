package com.example.pizzariabackend.pizzariabackend.services;

import com.example.pizzariabackend.pizzariabackend.config.messageHandling.ErrorMessages;
import com.example.pizzariabackend.pizzariabackend.config.messageHandling.SuccessMessages;
import com.example.pizzariabackend.pizzariabackend.dtos.in.addressDtos.AddressInDTO;
import com.example.pizzariabackend.pizzariabackend.dtos.in.addressDtos.AddressUpdateDTO;
import com.example.pizzariabackend.pizzariabackend.dtos.out.addressDtos.AddressOutDTO;
import com.example.pizzariabackend.pizzariabackend.entities.Address;
import com.example.pizzariabackend.pizzariabackend.repositories.AddressRepository;
import jakarta.persistence.EntityNotFoundException;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class AddressService{
    @Autowired
    private AddressRepository repository;
    @Autowired
    private ModelMapper modelMapper;
    public AddressOutDTO findById(Long id){
        Address addressDatabase = repository.findById(id).orElseThrow(() -> {
            throw new EntityNotFoundException(ErrorMessages.ENTITY_NOT_FOUND);
        });
        return modelMapper.map(addressDatabase, AddressOutDTO.class);
    }
    public List<AddressOutDTO> findAll(){
        List<Address> address = repository.findAll();
        if(address.isEmpty())
            throw new EntityNotFoundException(ErrorMessages.ENTITY_NOT_FOUND);
        List<AddressOutDTO> addressOutDTOS = new ArrayList<>();
        for(Address i : address){
            addressOutDTOS.add(modelMapper.map(i, AddressOutDTO.class));
        }
        return addressOutDTOS;
    }
    public String register(AddressInDTO request){
        Address addressToDatabase = modelMapper.map(request, Address.class);
        repository.save(addressToDatabase);
        return SuccessMessages.SAVED;
    }
    public String update(AddressUpdateDTO request){
        if(!repository.existsById(request.getId()))
            throw new EntityNotFoundException(ErrorMessages.ENTITY_NOT_FOUND);
        Address addressToDatabase = repository.getById(request.getId());
        //Put the variation below this line
        addressToDatabase.setNeighborhood(request.getNeighborhood());
        addressToDatabase.setNumber(request.getNumber());
        addressToDatabase.setStreet(request.getStreet());
        //Put the variation above this line
        repository.save(addressToDatabase);
        return SuccessMessages.UPDATED;
    }
    public String delete(Long id){
        if(!repository.existsById(id))
            throw new EntityNotFoundException(ErrorMessages.ENTITY_NOT_FOUND);
        Address addressDataBase = repository.getById(id);
        if(/*repository.isLinked(addressDataBase) && */addressDataBase.isStatus()) {
            repository.getById(id).setStatus(false);
            return SuccessMessages.DISABLED;
        } else if(!addressDataBase.isStatus()){
            return ErrorMessages.ALREADY_DISABLED;
        }
        repository.deleteById(id);
        return SuccessMessages.DELETED;
    }
}
