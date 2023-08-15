package com.example.pizzariabackend.pizzariabackend.entities;

import com.example.pizzariabackend.pizzariabackend.settings.ErrorMessages;
import com.example.pizzariabackend.pizzariabackend.settings.RegularExpressions;
import com.example.pizzariabackend.pizzariabackend.settings.abstractClasses.AbstractEntity;
import jakarta.persistence.Entity;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import jakarta.validation.constraints.*;
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
    @NotBlank(message = ErrorMessages.NOT_BLANK)
    @NotNull(message = ErrorMessages.NOT_NULL)
    @Max(value = 50, message = ErrorMessages.MAX_50)
    @Pattern(regexp = RegularExpressions.NAME, message = ErrorMessages.NAME)
    private String name;
    @NotNull(message = ErrorMessages.NOT_NULL)
    @NotEmpty(message = ErrorMessages.NOT_EMPTY)
    @OneToMany
    private List<Ingredient> ingredients;
}