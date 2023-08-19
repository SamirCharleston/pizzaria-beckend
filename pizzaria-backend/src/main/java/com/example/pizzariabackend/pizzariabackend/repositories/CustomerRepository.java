package com.example.pizzariabackend.pizzariabackend.repositories;

import com.example.pizzariabackend.pizzariabackend.entities.Customer;
import com.example.pizzariabackend.pizzariabackend.abstractClasses.interfaces.MainRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;


public interface CustomerRepository extends MainRepository<Customer> {
    @Query (value = "SELECT c FROM Customer c WHERE c.name = :name AND c.telephoneNumber = :tel ")
    Customer findByNameTelephone (@Param("tel") String tel, @Param("name") String name);
}