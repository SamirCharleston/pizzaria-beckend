package com.example.pizzariabackend.pizzariabackend.services;

import com.example.pizzariabackend.pizzariabackend.dtos.in.customerDtos.CustomerIdDTO;
import com.example.pizzariabackend.pizzariabackend.dtos.in.customerDtos.CustomerInDTO;
import com.example.pizzariabackend.pizzariabackend.dtos.in.customerDtos.CustomerUpdateDTO;
import com.example.pizzariabackend.pizzariabackend.dtos.out.customerDtos.CustomerOutDTO;
import com.example.pizzariabackend.pizzariabackend.entities.Customer;
import com.example.pizzariabackend.pizzariabackend.repositories.CustomerRepository;
import com.example.pizzariabackend.pizzariabackend.config.abstractClasses.AbstractService;

public class CustomerService extends AbstractService<
        CustomerRepository,
        CustomerIdDTO,
        CustomerInDTO,
        CustomerUpdateDTO,
        CustomerOutDTO,
        Customer> {
}
