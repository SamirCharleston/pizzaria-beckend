package com.example.pizzariabackend.pizzariabackend.dtos.out.customerDtos;

import com.example.pizzariabackend.pizzariabackend.abstractClasses.abstractDtos.AbstractOutDTO;
import com.example.pizzariabackend.pizzariabackend.entities.Address;
import jakarta.persistence.Column;
import jakarta.persistence.OneToOne;
import jakarta.persistence.PrimaryKeyJoinColumn;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CustomerOutDTO{
    private String name;
    private String telephoneNumber;
    private Address address;
}
