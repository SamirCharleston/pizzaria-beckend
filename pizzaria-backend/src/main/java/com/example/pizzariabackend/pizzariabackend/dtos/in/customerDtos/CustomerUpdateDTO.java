package com.example.pizzariabackend.pizzariabackend.dtos.in.customerDtos;

import com.example.pizzariabackend.pizzariabackend.entities.Address;
import com.example.pizzariabackend.pizzariabackend.settings.ErrorMessages;
import com.example.pizzariabackend.pizzariabackend.settings.RegularExpressions;
import com.example.pizzariabackend.pizzariabackend.settings.abstractClasses.abstractDtos.AbstractUpdateDTO;
import jakarta.persistence.OneToOne;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;

public class CustomerUpdateDTO extends AbstractUpdateDTO {
    @NotBlank(message = ErrorMessages.NOT_BLANK)
    @NotNull(message = ErrorMessages.NOT_NULL)
    @Pattern(regexp = RegularExpressions.NAME, message = ErrorMessages.NAME)
    private String name;
    @NotBlank(message = ErrorMessages.NOT_BLANK)
    @NotNull(message = ErrorMessages.NOT_NULL)
    @Pattern(regexp = RegularExpressions.TELEPHONE, message = ErrorMessages.TELEPHONE)
    private String telephoneNumber;
    @OneToOne
    @NotNull(message = ErrorMessages.NOT_NULL)
    private Address address;
}
