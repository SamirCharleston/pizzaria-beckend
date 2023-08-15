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
import org.hibernate.validator.constraints.br.CPF;


@Entity
@Table(name = "collaborators", schema = "public")
@NoArgsConstructor
@AllArgsConstructor
@Getter @Setter
public class Collaborator extends AbstractEntity {
    @NotBlank(message = ErrorMessages.NOT_BLANK)
    @NotNull(message = ErrorMessages.NOT_NULL)
    @Max(value = 50, message = ErrorMessages.MAX_50)
    @Pattern(regexp = RegularExpressions.NAME, message = ErrorMessages.NAME)
    private String name;
    @CPF(message = ErrorMessages.CPF)
    @NotNull(message = ErrorMessages.NOT_NULL)
    private String cpf;
    @Max(value = 50, message = ErrorMessages.MAX_50)
    @Pattern(regexp = RegularExpressions.SPACE_AND_LETTERS, message = ErrorMessages.SPACE_AND_LETTERS)
    private String function;
}
