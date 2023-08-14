package com.example.pizzariabackend.pizzariabackend.entities;

import com.example.pizzariabackend.pizzariabackend.settings.AbstractEntity;
import jakarta.persistence.*;
import jakarta.validation.constraints.Max;
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
    @Max(value = 50, message = max50ErrorMessage)
    @Pattern(regexp = spaceAndLettersRegex, message = spaceAndLettersErrorMessage)
    private String street;
    @Max(value = 10, message = max10ErrorMessage)
    @Pattern(regexp = onlyNumbersRegex, message = onlyNumbersErrorMessage)
    private String number;

    private String neighborhood;
}
