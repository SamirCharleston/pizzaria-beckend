package com.example.pizzariabackend.pizzariabackend.entities;

import com.example.pizzariabackend.pizzariabackend.settings.Config;
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
public class Collaborator extends Config {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @NotBlank(message = "This field can't be blank.")
    @NotNull(message = "This field can't be null.")
    @Max(value = 50, message = "This field supports at maximum of 50 characters.")
    @Pattern(regexp = nameRegex, message = "This field supports only alphabetic characters.")
    private String name;
    @CPF(message = "This field only supports a CPF type.")
    @NotNull(message = "This field can't be null.")
    private String cpf;
    @Pattern(regexp = nameRegex, message = "This only supports alphabetic characters.")
    private String function;
}
