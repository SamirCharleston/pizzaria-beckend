package com.example.pizzariabackend.pizzariabackend.entities;

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
@Table(name = "tb_ingredients", schema = "public")
@NoArgsConstructor
@AllArgsConstructor
@Getter @Setter
public class Ingredient {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @NotBlank(message = "This field can't be blank.")
    @NotNull(message = "This field can't be null.")
    @Max(value = 50, message = "This field supports at maximum of 50 characters.")
    @Pattern(regexp = "^[a-zA-Z\s]{50}$", message = "This field supports only spaces alphabetic characters.")
    private String name;
}