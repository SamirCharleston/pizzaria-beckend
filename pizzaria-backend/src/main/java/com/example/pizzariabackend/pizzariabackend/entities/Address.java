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
    @Max(value = 50, message = ErrorMessages.MAX_50)
    @Pattern(regexp = RegularExpressions.SPACE_AND_LETTERS, message = ErrorMessages.SPACE_AND_LETTERS)
    private String street;
    @Max(value = 10, message = ErrorMessages.MAX_10)
    @NotBlank(message = ErrorMessages.NOT_BLANK)
    @NotNull(message = ErrorMessages.NOT_NULL)
    @Pattern(regexp = RegularExpressions.ONLY_NUMBERS, message = ErrorMessages.ONLY_NUMBERS)
    private String number;
    @Max(value = 50, message = ErrorMessages.MAX_50)
    @NotBlank(message = ErrorMessages.NOT_BLANK)
    @NotNull(message = ErrorMessages.NOT_NULL)
    @Pattern(regexp = RegularExpressions.SPACE_AND_LETTERS, message = ErrorMessages.SPACE_AND_LETTERS)
    private String neighborhood;
}
