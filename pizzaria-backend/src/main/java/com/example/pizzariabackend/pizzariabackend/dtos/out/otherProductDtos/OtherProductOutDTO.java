package com.example.pizzariabackend.pizzariabackend.dtos.out.otherProductDtos;

import com.example.pizzariabackend.pizzariabackend.abstractClasses.abstractDtos.AbstractOutDTO;
import jakarta.persistence.Column;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;

@Getter
@Setter
public class OtherProductOutDTO{
    private String name;
    private BigDecimal price;
    private String kind;
}
