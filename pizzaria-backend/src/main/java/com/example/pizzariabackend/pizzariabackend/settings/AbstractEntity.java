package com.example.pizzariabackend.pizzariabackend.settings;

import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

public class AbstractEntity extends Config {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
}
