package com.example.pizzariabackend.pizzariabackend.entities;

import com.example.pizzariabackend.pizzariabackend.abstractClasses.AbstractEntity;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

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
