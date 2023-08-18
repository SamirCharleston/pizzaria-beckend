package com.example.pizzariabackend.pizzariabackend.repositories;

import com.example.pizzariabackend.pizzariabackend.entities.Ingredient;
import com.example.pizzariabackend.pizzariabackend.abstractClasses.interfaces.MainRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;


public interface IngredientRepository extends MainRepository<Ingredient> {
    @Query("SELECT COUNT(f) > 0 FROM Flavor f WHERE :ingredient MEMBER OF f.ingredients")
    boolean isLinked(@Param("ingredient") Ingredient ingredient);
}