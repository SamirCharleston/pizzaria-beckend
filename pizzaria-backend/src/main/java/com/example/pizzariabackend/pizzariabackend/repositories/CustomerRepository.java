package com.example.pizzariabackend.pizzariabackend.repositories;

import com.example.pizzariabackend.pizzariabackend.entities.Address;
import org.springframework.data.jpa.repository.JpaRepository;


public interface CustomerRepository extends JpaRepository<Address, Long> {
}