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
    @Positive(message = ErrorMessages.POSITIVE)
    private int quantity;
    @NotNull(message = ErrorMessages.NOT_NULL)
    @Enumerated(EnumType.STRING)
    private Size size;
    @OneToMany
    @NotNull(message = ErrorMessages.NOT_NULL)
    @NotEmpty(message = ErrorMessages.NOT_EMPTY)
    private List<Flavor> flavors;
}
