package com.example.pizzariabackend.pizzariabackend.entities;

import com.example.pizzariabackend.pizzariabackend.abstractClasses.AbstractEntity;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "ingredients", schema = "public")
@NoArgsConstructor
@AllArgsConstructor
@Getter @Setter
public class Ingredient extends AbstractEntity {
    @Column(unique = true, nullable = false, length = 50)
    private String name;
}