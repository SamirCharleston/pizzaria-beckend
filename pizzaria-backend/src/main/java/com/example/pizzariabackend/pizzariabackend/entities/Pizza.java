package com.example.pizzariabackend.pizzariabackend.entities;

import com.example.pizzariabackend.pizzariabackend.settings.ErrorMessages;
import com.example.pizzariabackend.pizzariabackend.settings.abstractClasses.AbstractEntity;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Entity
@Table(name = "pizzas", schema = "public")
@NoArgsConstructor
@AllArgsConstructor
@Getter @Setter
public class Pizza extends AbstractEntity {
    private int quantity;
    @Enumerated(EnumType.STRING)
    @Column(nullable = false, length = 2)
    private Size size;
    @OneToMany
    @JoinColumn(nullable = false)
    private List<Flavor> flavors;
}
