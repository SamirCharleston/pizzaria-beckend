package com.example.pizzariabackend.pizzariabackend.services;

import com.example.pizzariabackend.pizzariabackend.config.messageHandling.ErrorMessages;
import com.example.pizzariabackend.pizzariabackend.config.messageHandling.SuccessMessages;
import com.example.pizzariabackend.pizzariabackend.dtos.in.orderDtos.OrderInDTO;
import com.example.pizzariabackend.pizzariabackend.dtos.in.orderDtos.OrderUpdateDTO;
import com.example.pizzariabackend.pizzariabackend.dtos.out.orderDtos.OrderOutDTO;
import com.example.pizzariabackend.pizzariabackend.entities.Order;
import com.example.pizzariabackend.pizzariabackend.repositories.OrderRepository;
import jakarta.persistence.EntityNotFoundException;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class OrderService{
    @Autowired
    private OrderRepository repository;
    @Autowired
    private ModelMapper modelMapper;
    public OrderOutDTO findById(Long id){
        Order orderDatabase = repository.findById(id).orElseThrow(() -> {
            throw new EntityNotFoundException(ErrorMessages.ENTITY_NOT_FOUND);
        });
        return modelMapper.map(orderDatabase, OrderOutDTO.class);
    }
    public List<OrderOutDTO> findAll(){
        List<Order> orders = repository.findAll();
        if(orders.isEmpty())
            throw new EntityNotFoundException(ErrorMessages.ENTITY_NOT_FOUND);
        List<OrderOutDTO> orderOutDTOS = new ArrayList<>();
        for(Order i : orders){
            orderOutDTOS.add(modelMapper.map(i, OrderOutDTO.class));
        }
        return orderOutDTOS;
    }
    public String register(OrderInDTO request){
        Order orderToDatabase = modelMapper.map(request, Order.class);
        repository.save(orderToDatabase);
        return SuccessMessages.SAVED;
    }
    public String update(OrderUpdateDTO request){
        Order orderToDatabase = modelMapper.map(request, Order.class);
        repository.save(orderToDatabase);
        return SuccessMessages.UPDATED;
    }
    public String delete(Long id){
        if(!repository.existsById(id))
            throw new EntityNotFoundException(ErrorMessages.ENTITY_NOT_FOUND);
        Order orderDataBase = repository.getById(id);
        if(/*repository.isLinked(orderDataBase) && */orderDataBase.isStatus()) {
            repository.getById(id).setStatus(false);
            return SuccessMessages.DISABLED;
        } else if(!orderDataBase.isStatus()){
            return ErrorMessages.ALREADY_DISABLED;
        }
        repository.deleteById(id);
        return SuccessMessages.DELETED;
    }
}
