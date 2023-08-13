package com.example.pizzariabackend.pizzariabackend.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "pizzas", schema = "public")
@NoArgsConstructor
@AllArgsConstructor
@Getter @Setter
public class Pizza {
}
