package com.example.pizzariabackend.pizzariabackend.dtos.in.collaboratorDtos;

import com.example.pizzariabackend.pizzariabackend.config.messageHandling.ErrorMessages;
import com.example.pizzariabackend.pizzariabackend.config.validation.RegexValidation;
import com.example.pizzariabackend.pizzariabackend.abstractClasses.abstractDtos.AbstractUpdateDTO;
import jakarta.validation.constraints.*;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.validator.constraints.br.CPF;
@Getter
@Setter
public class CollaboratorUpdateDTO {
    @NotNull(message = ErrorMessages.NOT_NULL)
    private Long id;
    @NotBlank(message = ErrorMessages.NOT_BLANK)
    @NotNull(message = ErrorMessages.NOT_NULL)
    @Size(max = 50, message = ErrorMessages.MAX_50)
    @Pattern(regexp = RegexValidation.NAME, message = ErrorMessages.NAME)
    private String name;
    @CPF(message = ErrorMessages.CPF)
    @NotNull(message = ErrorMessages.NOT_NULL)
    private String cpf;
    @Size(max = 50, message = ErrorMessages.MAX_50)
    @NotNull(message = ErrorMessages.NOT_NULL)
    @Pattern(regexp = RegexValidation.SPACE_AND_LETTERS, message = ErrorMessages.SPACE_AND_LETTERS)
    private String function;
}
