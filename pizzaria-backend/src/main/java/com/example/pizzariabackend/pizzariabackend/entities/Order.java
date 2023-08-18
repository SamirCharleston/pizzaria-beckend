package com.example.pizzariabackend.pizzariabackend.entities;

import com.example.pizzariabackend.pizzariabackend.abstractClasses.AbstractEntity;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Entity
@Table(name = "orders", schema = "public")
@NoArgsConstructor
@AllArgsConstructor
@Getter @Setter
public class Order extends AbstractEntity {
    @ManyToMany
    @JoinTable
    private List<Collaborator> collaborators;
    @OneToMany
    private List<OtherProduct> otherProducts;
    @ManyToOne
    @JoinColumn(nullable = false)
    private Customer customer;
    @ManyToMany
    @JoinTable
    private List<Pizza> pizzas;
    private boolean delivered;
}
