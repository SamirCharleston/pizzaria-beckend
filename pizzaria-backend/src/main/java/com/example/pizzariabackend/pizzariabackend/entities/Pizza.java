package com.example.pizzariabackend.pizzariabackend.entities;

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
    @Positive(message = ERROR_MESSAGES.POSITIVE)
    private int quantity;
    @NotNull(message = ERROR_MESSAGES.NOT_NULL)
    @Enumerated(EnumType.STRING)
    private Size size;
    @OneToMany
    @NotNull(message = ERROR_MESSAGES.NOT_NULL)
    @NotEmpty(message = ERROR_MESSAGES.NOT_EMPTY)
    private List<Flavor> flavors;
}
