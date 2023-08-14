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
@Table(name = "addresses", schema = "public")
@NoArgsConstructor
@AllArgsConstructor
@Getter @Setter
public class Address extends AbstractEntity {
    @Max(value = 50, message = ERROR_MESSAGES.MAX_50)
    @Pattern(regexp = REGULAR_EXPRESSIONS.SPACE_AND_LETTERS, message = ERROR_MESSAGES.SPACE_AND_LETTERS)
    private String street;
    @Max(value = 10, message = ERROR_MESSAGES.MAX_10)
    @NotBlank(message = ERROR_MESSAGES.NOT_BLANK)
    @NotNull(message = ERROR_MESSAGES.NOT_NULL)
    @Pattern(regexp = REGULAR_EXPRESSIONS.ONLY_NUMBERS, message = ERROR_MESSAGES.ONLY_NUMBERS)
    private String number;
    @Max(value = 50, message = ERROR_MESSAGES.MAX_50)
    @NotBlank(message = ERROR_MESSAGES.NOT_BLANK)
    @NotNull(message = ERROR_MESSAGES.NOT_NULL)
    @Pattern(regexp = REGULAR_EXPRESSIONS.SPACE_AND_LETTERS, message = ERROR_MESSAGES.SPACE_AND_LETTERS)
    private String neighborhood;
}
