package com.example.pizzariabackend.pizzariabackend.entities;

import com.example.pizzariabackend.pizzariabackend.settings.abstractClasses.AbstractEntity;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
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
    @NotNull(message = ERROR_MESSAGES.NOT_NULL)
    private List<Collaborator> collaborators;
    @OneToMany
    private List<OtherProduct> otherProducts;
    @ManyToOne
    @NotNull(message = ERROR_MESSAGES.NOT_NULL)
    private Customer customer;
    @ManyToMany
    @JoinTable
    @NotNull(message = ERROR_MESSAGES.NOT_NULL)
    private List<Pizza> pizzas;
    private boolean delivered;
}
