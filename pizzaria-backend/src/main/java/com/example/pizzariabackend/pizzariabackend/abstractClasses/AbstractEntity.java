package com.example.pizzariabackend.pizzariabackend.abstractClasses;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@MappedSuperclass
public abstract class AbstractEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @Setter
    boolean status;
    @PrePersist
    private void prePersist(){
        this.status = true;
    }
}
