package com.example.pizzariabackend.pizzariabackend.services;

import com.example.pizzariabackend.pizzariabackend.config.messageHandling.ErrorMessages;
import com.example.pizzariabackend.pizzariabackend.config.messageHandling.SuccessMessages;
import com.example.pizzariabackend.pizzariabackend.dtos.in.customerDtos.CustomerInDTO;
import com.example.pizzariabackend.pizzariabackend.dtos.in.customerDtos.CustomerUpdateDTO;
import com.example.pizzariabackend.pizzariabackend.dtos.out.customerDtos.CustomerOutDTO;
import com.example.pizzariabackend.pizzariabackend.entities.Collaborator;
import com.example.pizzariabackend.pizzariabackend.entities.Customer;
import com.example.pizzariabackend.pizzariabackend.repositories.CustomerRepository;
import jakarta.persistence.EntityNotFoundException;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class CustomerService {
    @Autowired
    private CustomerRepository repository;
    @Autowired
    private ModelMapper modelMapper;
    public CustomerOutDTO findById(Long id){
        Customer customerDatabase = repository.findById(id).orElseThrow(() -> {
            throw new EntityNotFoundException(ErrorMessages.ENTITY_NOT_FOUND);
        });
        return modelMapper.map(customerDatabase, CustomerOutDTO.class);
    }
    public List<CustomerOutDTO> findAll(){
        List<Customer> customers = repository.findAll();
        if(customers.isEmpty())
            throw new EntityNotFoundException(ErrorMessages.ENTITY_NOT_FOUND);
        List<CustomerOutDTO> customerOutDTOS = new ArrayList<>();
        for(Customer i : customers){
            customerOutDTOS.add(modelMapper.map(i, CustomerOutDTO.class));
        }
        return customerOutDTOS;
    }
    public String register(CustomerInDTO request){
        Customer customerToDatabase = modelMapper.map(request, Customer.class);
        repository.save(customerToDatabase);
        return SuccessMessages.SAVED;
    }
    public String update(CustomerUpdateDTO request){
        if(!repository.existsById(request.getId()))
            throw new EntityNotFoundException(ErrorMessages.ENTITY_NOT_FOUND);
        Customer customerToDatabase = repository.getById(request.getId());
        //Put the variation below this line
        customerToDatabase.setAddress(request.getAddress());
        customerToDatabase.setName(request.getName());
        customerToDatabase.setTelephoneNumber(request.getTelephoneNumber());
        //Put the variation above this line
        repository.save(customerToDatabase);
        return SuccessMessages.UPDATED;
    }
    public String delete(Long id){
        if(!repository.existsById(id))
            throw new EntityNotFoundException(ErrorMessages.ENTITY_NOT_FOUND);
        Customer customerDataBase = repository.getById(id);
        if(/*repository.isLinked(customerDataBase) && */customerDataBase.isStatus()) {
            repository.getById(id).setStatus(false);
            return SuccessMessages.DISABLED;
        } else if(!customerDataBase.isStatus()){
            return ErrorMessages.ALREADY_DISABLED;
        }
        repository.deleteById(id);
        return SuccessMessages.DELETED;
    }
}
