package com.example.pizzariabackend.pizzariabackend.entities;

import com.example.pizzariabackend.pizzariabackend.settings.abstractClasses.AbstractEntity;
import jakarta.persistence.*;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
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
    @NotBlank(message = ERROR_MESSAGES.NOT_BLANK)
    @NotNull(message = ERROR_MESSAGES.NOT_NULL)
    @Max(value = 50, message = ERROR_MESSAGES.MAX_50)
    @Pattern(regexp = REGULAR_EXPRESSIONS.NAME, message = ERROR_MESSAGES.NAME)
    private String name;
}