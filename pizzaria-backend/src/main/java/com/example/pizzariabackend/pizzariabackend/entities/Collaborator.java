package com.example.pizzariabackend.pizzariabackend.entities;

import com.example.pizzariabackend.pizzariabackend.settings.ErrorMessages;
import com.example.pizzariabackend.pizzariabackend.settings.RegularExpressions;
import com.example.pizzariabackend.pizzariabackend.settings.abstractClasses.AbstractEntity;
import jakarta.persistence.*;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.validator.constraints.br.CPF;


@Entity
@Table(name = "collaborators", schema = "public")
@NoArgsConstructor
@AllArgsConstructor
@Getter @Setter
public class Collaborator extends AbstractEntity {
    @Column(nullable = false, length = 50)
    private String name;
    @Column(unique = true, nullable = false, length = 15)
    private String cpf;
    @Column(length = 50, nullable = false)
    private String function;
}
