package com.example.pizzariabackend.pizzariabackend.services;

import com.example.pizzariabackend.pizzariabackend.dtos.in.orderDtos.OrderIdDTO;
import com.example.pizzariabackend.pizzariabackend.dtos.in.orderDtos.OrderInDTO;
import com.example.pizzariabackend.pizzariabackend.dtos.in.orderDtos.OrderUpdateDTO;
import com.example.pizzariabackend.pizzariabackend.dtos.out.orderDtos.OrderOutDTO;
import com.example.pizzariabackend.pizzariabackend.entities.Order;
import com.example.pizzariabackend.pizzariabackend.repositories.OrderRepository;
import com.example.pizzariabackend.pizzariabackend.config.abstractClasses.AbstractService;

public class OrderService extends AbstractService<
        OrderRepository,
        OrderIdDTO,
        OrderInDTO,
        OrderUpdateDTO,
        OrderOutDTO,
        Order> {
}
