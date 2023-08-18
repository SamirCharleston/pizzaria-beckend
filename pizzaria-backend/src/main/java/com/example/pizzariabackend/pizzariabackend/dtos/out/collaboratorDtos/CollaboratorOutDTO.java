package com.example.pizzariabackend.pizzariabackend.dtos.out.collaboratorDtos;

import com.example.pizzariabackend.pizzariabackend.abstractClasses.abstractDtos.AbstractOutDTO;
import jakarta.persistence.Column;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CollaboratorOutDTO extends AbstractOutDTO {
    private String name;
    private String cpf;
    private String function;
}
