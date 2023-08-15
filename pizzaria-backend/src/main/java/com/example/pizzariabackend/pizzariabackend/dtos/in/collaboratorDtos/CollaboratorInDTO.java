package com.example.pizzariabackend.pizzariabackend.dtos.in.collaboratorDtos;

import com.example.pizzariabackend.pizzariabackend.settings.ErrorMessages;
import com.example.pizzariabackend.pizzariabackend.settings.RegularExpressions;
import com.example.pizzariabackend.pizzariabackend.settings.abstractClasses.abstractDtos.AbstractInDTO;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import org.hibernate.validator.constraints.br.CPF;

public class CollaboratorInDTO extends AbstractInDTO {
    @NotBlank(message = ErrorMessages.NOT_BLANK)
    @NotNull(message = ErrorMessages.NOT_NULL)
    @Max(value = 50, message = ErrorMessages.MAX_50)
    @Pattern(regexp = RegularExpressions.NAME, message = ErrorMessages.NAME)
    private String name;
    @CPF(message = ErrorMessages.CPF)
    @NotNull(message = ErrorMessages.NOT_NULL)
    private String cpf;
    @Max(value = 50, message = ErrorMessages.MAX_50)
    @NotNull(message = ErrorMessages.NOT_NULL)
    @Pattern(regexp = RegularExpressions.SPACE_AND_LETTERS, message = ErrorMessages.SPACE_AND_LETTERS)
    private String function;
}
