package com.example.pizzariabackend.pizzariabackend.services;

import com.example.pizzariabackend.pizzariabackend.config.customExceptions.OrderAlreadyDeliveredException;
import com.example.pizzariabackend.pizzariabackend.config.customExceptions.OrderCanceledException;
import com.example.pizzariabackend.pizzariabackend.config.messageHandling.ErrorMessages;
import com.example.pizzariabackend.pizzariabackend.config.messageHandling.SuccessMessages;
import com.example.pizzariabackend.pizzariabackend.dtos.in.orderDtos.OrderInDTO;
import com.example.pizzariabackend.pizzariabackend.dtos.in.orderDtos.OrderUpdateDTO;
import com.example.pizzariabackend.pizzariabackend.dtos.out.orderDtos.OrderOutDTO;
import com.example.pizzariabackend.pizzariabackend.entities.Flavor;
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
        if(!repository.existsById(request.getId()))
            throw new EntityNotFoundException(ErrorMessages.ENTITY_NOT_FOUND);
        Order orderToDatabase = repository.getById(request.getId());
        //Put the variation below this line
        if(!orderToDatabase.isStatus())
            throw new OrderCanceledException(ErrorMessages.ORDER_CANCELED);
        if(orderToDatabase.isDelivered())
            throw new OrderAlreadyDeliveredException(ErrorMessages.ORDER_DELIVERED);
        if(request.getCollaborators() != null && !request.getCollaborators().isEmpty())
            orderToDatabase.setCollaborators(request.getCollaborators());
        if(request.getCustomer() != null)
            orderToDatabase.setCustomer(request.getCustomer());
        if(request.getOtherProducts() != null && !request.getOtherProducts().isEmpty())
            orderToDatabase.setOtherProducts(request.getOtherProducts());
        if(request.getPizzas() != null && !request.getPizzas().isEmpty())
            orderToDatabase.setPizzas(request.getPizzas());
        //Put the variation above this line
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
