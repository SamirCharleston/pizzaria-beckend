package com.example.pizzariabackend.pizzariabackend.entities;

import com.example.pizzariabackend.pizzariabackend.abstractClasses.AbstractEntity;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Entity
@Table(name = "flavors", schema = "public")
@NoArgsConstructor
@AllArgsConstructor
@Getter @Setter
public class Flavor extends AbstractEntity {
    @Column(unique = true, nullable = false, length = 50)
    private String name;
    @OneToMany
    @Column(nullable = false)
    private List<Ingredient> ingredients;
}