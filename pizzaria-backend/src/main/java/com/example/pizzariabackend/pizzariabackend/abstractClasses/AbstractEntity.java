package com.example.pizzariabackend.pizzariabackend.abstractClasses;

import jakarta.persistence.*;
import lombok.Getter;
@Getter
@MappedSuperclass
public abstract class AbstractEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
}
