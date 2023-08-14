package com.example.pizzariabackend.pizzariabackend.settings.abstractClasses;

import com.example.pizzariabackend.pizzariabackend.settings.Config;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Getter;
@Getter
public class AbstractEntity extends Config {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
}
