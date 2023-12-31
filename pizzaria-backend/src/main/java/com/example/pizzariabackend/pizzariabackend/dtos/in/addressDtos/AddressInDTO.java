package com.example.pizzariabackend.pizzariabackend.dtos.in.addressDtos;

import com.example.pizzariabackend.pizzariabackend.config.messageHandling.ErrorMessages;
import com.example.pizzariabackend.pizzariabackend.config.validation.RegexValidation;
import com.example.pizzariabackend.pizzariabackend.abstractClasses.abstractDtos.AbstractInDTO;
import jakarta.validation.constraints.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class AddressInDTO extends AbstractInDTO {
    @NotBlank(message = ErrorMessages.NOT_BLANK)
    @NotNull(message = ErrorMessages.NOT_NULL)
    @Size(max = 50, message = ErrorMessages.MAX_50)
    @Pattern(regexp = RegexValidation.LETTERS_SPACES_NUMBERS, message = ErrorMessages.SPACE_AND_LETTERS)
    private String street;
    @Size(max = 10, message = ErrorMessages.MAX_10)
    @NotBlank(message = ErrorMessages.NOT_BLANK)
    @NotNull(message = ErrorMessages.NOT_NULL)
    @Pattern(regexp = RegexValidation.ONLY_NUMBERS, message = ErrorMessages.ONLY_NUMBERS)
    private String number;
    @Size(max = 50, message = ErrorMessages.MAX_50)
    @NotBlank(message = ErrorMessages.NOT_BLANK)
    @NotNull(message = ErrorMessages.NOT_NULL)
    @Pattern(regexp = RegexValidation.LETTERS_SPACES_NUMBERS, message = ErrorMessages.SPACE_AND_LETTERS)
    private String neighborhood;
}
