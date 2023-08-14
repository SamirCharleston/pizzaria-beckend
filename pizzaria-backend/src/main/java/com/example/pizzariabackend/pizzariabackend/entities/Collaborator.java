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
import org.hibernate.validator.constraints.br.CPF;


@Entity
@Table(name = "collaborators", schema = "public")
@NoArgsConstructor
@AllArgsConstructor
@Getter @Setter
public class Collaborator extends AbstractEntity {
    @NotBlank(message = ERROR_MESSAGES.NOT_BLANK)
    @NotNull(message = ERROR_MESSAGES.NOT_NULL)
    @Max(value = 50, message = ERROR_MESSAGES.MAX_50)
    @Pattern(regexp = REGULAR_EXPRESSIONS.NAME, message = ERROR_MESSAGES.NAME)
    private String name;
    @CPF(message = ERROR_MESSAGES.CPF)
    @NotNull(message = ERROR_MESSAGES.NOT_NULL)
    private String cpf;
    @Max(value = 50, message = ERROR_MESSAGES.MAX_50)
    @Pattern(regexp = REGULAR_EXPRESSIONS.SPACE_AND_LETTERS, message = ERROR_MESSAGES.SPACE_AND_LETTERS)
    private String function;
}
