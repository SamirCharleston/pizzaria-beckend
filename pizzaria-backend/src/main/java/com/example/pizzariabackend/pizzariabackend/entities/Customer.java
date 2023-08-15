package com.example.pizzariabackend.pizzariabackend.entities;

import com.example.pizzariabackend.pizzariabackend.settings.abstractClasses.AbstractEntity;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "customers", schema = "public")
@NoArgsConstructor
@AllArgsConstructor
@Getter @Setter
public class Customer extends AbstractEntity {
    @Column(nullable = false, length = 50)
    private String name;
    @Column(unique = true, nullable = false, length = 15)
    private String telephoneNumber;
    @OneToOne
    private Address address;
}
