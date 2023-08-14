package com.example.pizzariabackend.pizzariabackend.dtos.request.customerDtos;

import com.example.pizzariabackend.pizzariabackend.entities.Address;
import com.example.pizzariabackend.pizzariabackend.settings.abstractClasses.abstractDtos.AbstractInDTO;
import jakarta.persistence.OneToOne;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;

public class CustomerInDTO extends AbstractInDTO {
    @NotBlank(message = ERROR_MESSAGES.NOT_BLANK)
    @NotNull(message = ERROR_MESSAGES.NOT_NULL)
    @Pattern(regexp = REGULAR_EXPRESSIONS.NAME, message = ERROR_MESSAGES.NAME)
    private String name;
    @NotBlank(message = ERROR_MESSAGES.NOT_BLANK)
    @NotNull(message = ERROR_MESSAGES.NOT_NULL)
    @Pattern(regexp = REGULAR_EXPRESSIONS.TELEPHONE, message = ERROR_MESSAGES.TELEPHONE)
    private String telephoneNumber;
    @OneToOne
    @NotNull(message = ERROR_MESSAGES.NOT_NULL)
    private Address address;
}
