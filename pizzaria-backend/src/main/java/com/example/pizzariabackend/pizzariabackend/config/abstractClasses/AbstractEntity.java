package com.example.pizzariabackend.pizzariabackend.config.abstractClasses;

import jakarta.persistence.*;
import lombok.Getter;
@Getter
@MappedSuperclass
public class AbstractEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
}
