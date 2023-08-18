package com.example.pizzariabackend.pizzariabackend.dtos.in.collaboratorDtos;

import com.example.pizzariabackend.pizzariabackend.config.messageHandling.ErrorMessages;
import com.example.pizzariabackend.pizzariabackend.config.validation.RegexValidation;
import com.example.pizzariabackend.pizzariabackend.abstractClasses.abstractDtos.AbstractUpdateDTO;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import org.hibernate.validator.constraints.br.CPF;

public class CollaboratorUpdateDTO extends AbstractUpdateDTO {
    @NotBlank(message = ErrorMessages.NOT_BLANK)
    @NotNull(message = ErrorMessages.NOT_NULL)
    @Max(value = 50, message = ErrorMessages.MAX_50)
    @Pattern(regexp = RegexValidation.NAME, message = ErrorMessages.NAME)
    private String name;
    @CPF(message = ErrorMessages.CPF)
    @NotNull(message = ErrorMessages.NOT_NULL)
    private String cpf;
    @Max(value = 50, message = ErrorMessages.MAX_50)
    @NotNull(message = ErrorMessages.NOT_NULL)
    @Pattern(regexp = RegexValidation.SPACE_AND_LETTERS, message = ErrorMessages.SPACE_AND_LETTERS)
    private String function;
}
