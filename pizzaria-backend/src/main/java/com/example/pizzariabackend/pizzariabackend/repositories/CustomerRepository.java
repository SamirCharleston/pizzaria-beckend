package com.example.pizzariabackend.pizzariabackend.repositories;

import com.example.pizzariabackend.pizzariabackend.entities.Address;
import com.example.pizzariabackend.pizzariabackend.entities.Customer;
import com.example.pizzariabackend.pizzariabackend.settings.abstractClasses.MainRepository;
import org.springframework.data.jpa.repository.JpaRepository;


public interface CustomerRepository extends MainRepository<Customer> {
}