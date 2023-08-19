package com.example.pizzariabackend.pizzariabackend.services;

import com.example.pizzariabackend.pizzariabackend.config.customExceptions.OrderAlreadyDeliveredException;
import com.example.pizzariabackend.pizzariabackend.config.customExceptions.OrderCanceledException;
import com.example.pizzariabackend.pizzariabackend.config.customExceptions.PizzaSizeException;
import com.example.pizzariabackend.pizzariabackend.config.messageHandling.ErrorMessages;
import com.example.pizzariabackend.pizzariabackend.config.messageHandling.SuccessMessages;
import com.example.pizzariabackend.pizzariabackend.dtos.in.orderDtos.CreateOrderDTO;
import com.example.pizzariabackend.pizzariabackend.dtos.in.orderDtos.OrderInDTO;
import com.example.pizzariabackend.pizzariabackend.dtos.in.orderDtos.OrderUpdateDTO;
import com.example.pizzariabackend.pizzariabackend.dtos.out.orderDtos.OrderOutDTO;
import com.example.pizzariabackend.pizzariabackend.entities.*;
import com.example.pizzariabackend.pizzariabackend.repositories.CollaboratorRepository;
import com.example.pizzariabackend.pizzariabackend.repositories.CustomerRepository;
import com.example.pizzariabackend.pizzariabackend.repositories.FlavorRepository;
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
    private OrderRepository orderRepository;
    @Autowired
    private CollaboratorRepository collaboratorRepository;
    @Autowired
    private CustomerRepository customerRepository;
    @Autowired
    private FlavorRepository flavorRepository;
    @Autowired
    private ModelMapper modelMapper;
    public OrderOutDTO findById(Long id){
        Order orderDatabase = orderRepository.findById(id).orElseThrow(() -> {
            throw new EntityNotFoundException(ErrorMessages.ENTITY_NOT_FOUND);
        });
        return modelMapper.map(orderDatabase, OrderOutDTO.class);
    }
    public List<OrderOutDTO> findAll(){
        List<Order> orders = orderRepository.findAll();
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
        orderRepository.save(orderToDatabase);
        return SuccessMessages.SAVED;
    }
    public String update(OrderUpdateDTO request){
        if(!orderRepository.existsById(request.getId()))
            throw new EntityNotFoundException(ErrorMessages.ENTITY_NOT_FOUND);
        Order orderToDatabase = orderRepository.getById(request.getId());
        //Put the variation below this line
        if(!orderToDatabase.isStatus())
            throw new OrderCanceledException(ErrorMessages.ORDER_CANCELED);
        if(request.getCollaborator() != null)
            orderToDatabase.setCollaborator(request.getCollaborator());
        if(request.getCustomer() != null)
            orderToDatabase.setCustomer(request.getCustomer());
        if(request.getOtherProducts() != null && !request.getOtherProducts().isEmpty())
            orderToDatabase.setOtherProducts(request.getOtherProducts());
        if(request.getPizzas() != null && !request.getPizzas().isEmpty())
            orderToDatabase.setPizzas(request.getPizzas());
        //Put the variation above this line
        orderRepository.save(orderToDatabase);
        return SuccessMessages.UPDATED;
    }
    public String delete(Long id){
        if(!orderRepository.existsById(id))
            throw new EntityNotFoundException(ErrorMessages.ENTITY_NOT_FOUND);
        Order orderDataBase = orderRepository.getById(id);
        if(/*repository.isLinked(orderDataBase) && */orderDataBase.isStatus()) {
            orderRepository.getById(id).setStatus(false);
            return SuccessMessages.DISABLED;
        } else if(!orderDataBase.isStatus()){
            return ErrorMessages.ALREADY_DISABLED;
        }
        orderRepository.deleteById(id);
        return SuccessMessages.DELETED;
    }
    public String createOrder (CreateOrderDTO orderDTO) throws PizzaSizeException {
        Collaborator collaborator = collaboratorRepository.findByCpf(orderDTO.getCollaboratorCpf());
        if (collaborator == null){
            throw new EntityNotFoundException(ErrorMessages.ENTITY_NOT_FOUND);
        }
        Customer customer = customerRepository.findByNameTelephone(orderDTO.getCustomerTelephoneNumber(),
                orderDTO.getCustomerName());
        if (customer == null){
            throw new EntityNotFoundException(ErrorMessages.ENTITY_NOT_FOUND);
        }
        Order orderEntity = new Order();
        List<Pizza> pizzas = new ArrayList<>();
        for (Pizza pizza :orderDTO.getPizzas()){
            if (pizza.getSize().toString().equals("S") && pizza.getFlavors().size() > 1){
                throw new PizzaSizeException(ErrorMessages.PIZZA_SIZE);
            } else if (pizza.getSize().toString().equals("M") && pizza.getFlavors().size() > 2){
                throw new PizzaSizeException(ErrorMessages.PIZZA_SIZE);
            }else if (pizza.getSize().toString().equals("L") && pizza.getFlavors().size() > 3){
                throw new PizzaSizeException(ErrorMessages.PIZZA_SIZE);
            }else if (pizza.getSize().toString().equals("XL") && pizza.getFlavors().size() > 4){
                throw new PizzaSizeException(ErrorMessages.PIZZA_SIZE);
            }
            List<Flavor> flavors = new ArrayList<>();
            for(Flavor flavor : pizza.getFlavors()){
                Flavor flavorTest = flavorRepository.findByName(flavor.getName());
                if(flavorTest == null){
                    throw new EntityNotFoundException(ErrorMessages.ENTITY_NOT_FOUND);
                }
                flavors.add(flavorTest);
            }
            pizza.setFlavors(flavors);
            pizzas.add(pizza);

        }
        orderEntity.setPizzas(pizzas);
        orderEntity.setCustomer(customer);
        orderEntity.setCollaborator(collaborator);
        orderEntity.setDelivery(orderDTO.isDelivery());
        return SuccessMessages.ORDER_CREATED;
    }
}
