package com.example.pizzariabackend.pizzariabackend.dtos.out.addressDtos;

import com.example.pizzariabackend.pizzariabackend.abstractClasses.abstractDtos.AbstractOutDTO;
import jakarta.persistence.Column;
import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class AddressOutDTO extends AbstractOutDTO {
    private String street;
    private String number;
    private String neighborhood;
}
