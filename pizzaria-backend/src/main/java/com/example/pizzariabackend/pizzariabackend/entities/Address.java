package com.example.pizzariabackend.pizzariabackend.entities;

import com.example.pizzariabackend.pizzariabackend.settings.ErrorMessages;
import com.example.pizzariabackend.pizzariabackend.settings.RegularExpressions;
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
@Table(name = "addresses", schema = "public")
@NoArgsConstructor
@AllArgsConstructor
@Getter @Setter
public class Address extends AbstractEntity {
    @Column(nullable = false, length = 50)
    private String street;
    @Column(nullable = false, length = 10)
    private String number;
    @Column(nullable = false, length = 50)
    private String neighborhood;
}
