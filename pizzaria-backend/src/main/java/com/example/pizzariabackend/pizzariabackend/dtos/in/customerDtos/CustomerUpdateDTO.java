package com.example.pizzariabackend.pizzariabackend.dtos.in.customerDtos;

import com.example.pizzariabackend.pizzariabackend.entities.Address;
import com.example.pizzariabackend.pizzariabackend.config.messageHandling.ErrorMessages;
import com.example.pizzariabackend.pizzariabackend.config.validation.RegexValidation;
import com.example.pizzariabackend.pizzariabackend.abstractClasses.abstractDtos.AbstractUpdateDTO;
import jakarta.persistence.OneToOne;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CustomerUpdateDTO {
    @NotNull(message = ErrorMessages.NOT_NULL)
    private Long id;
    @NotBlank(message = ErrorMessages.NOT_BLANK)
    @NotNull(message = ErrorMessages.NOT_NULL)
    @Pattern(regexp = RegexValidation.NAME, message = ErrorMessages.NAME)
    private String name;
    @NotBlank(message = ErrorMessages.NOT_BLANK)
    @NotNull(message = ErrorMessages.NOT_NULL)
    @Pattern(regexp = RegexValidation.TELEPHONE, message = ErrorMessages.TELEPHONE)
    private String telephoneNumber;
    @OneToOne
    @NotNull(message = ErrorMessages.NOT_NULL)
    private Address address;
}
