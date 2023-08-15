package com.example.pizzariabackend.pizzariabackend.settings.abstractClasses;

import com.example.pizzariabackend.pizzariabackend.settings.Config;
import jakarta.persistence.*;
import lombok.Getter;
@Getter
@MappedSuperclass
public class AbstractEntity extends Config {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
}
