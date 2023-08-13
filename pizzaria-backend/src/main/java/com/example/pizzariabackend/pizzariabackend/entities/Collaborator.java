package com.example.pizzariabackend.pizzariabackend.entities;

import jakarta.persistence.*;
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
public class Collaborator {
    private final String regexp = "^[a-zA-Z\s]{50}$";
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @Pattern(regexp = regexp, message = "This only supports alphabetic characters.")
    private String name;
    @CPF(message = "This field only supports a CPF type.")
    private String cpf;
    @Pattern(regexp = regexp, message = "This only supports alphabetic characters.")
    private String function;
}
