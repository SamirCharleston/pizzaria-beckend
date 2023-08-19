package com.example.pizzariabackend.pizzariabackend.repositories;

import com.example.pizzariabackend.pizzariabackend.entities.Flavor;
import com.example.pizzariabackend.pizzariabackend.abstractClasses.interfaces.MainRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;


public interface FlavorRepository extends MainRepository<Flavor> {
    @Query(value = "SELECT f FROM Flavor f WHERE f.name = :name")
    Flavor findByName (@Param("name") String name);
}