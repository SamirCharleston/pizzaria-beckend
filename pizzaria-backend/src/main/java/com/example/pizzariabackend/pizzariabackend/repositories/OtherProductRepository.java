package com.example.pizzariabackend.pizzariabackend.repositories;

import com.example.pizzariabackend.pizzariabackend.entities.Flavor;
import com.example.pizzariabackend.pizzariabackend.entities.OtherProduct;
import com.example.pizzariabackend.pizzariabackend.abstractClasses.interfaces.MainRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;


public interface OtherProductRepository extends MainRepository<OtherProduct> {
    @Query(value = "SELECT o FROM OtherProduct o WHERE o.name = :name")
    OtherProduct findByName (@Param("name") String name);
}