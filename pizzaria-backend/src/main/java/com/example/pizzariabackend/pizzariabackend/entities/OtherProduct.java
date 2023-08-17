package com.example.pizzariabackend.pizzariabackend.entities;

import com.example.pizzariabackend.pizzariabackend.config.abstractClasses.AbstractEntity;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import java.math.BigDecimal;

@Entity
@Table(name = "other_products", schema = "public")
@NoArgsConstructor
@AllArgsConstructor
@Getter @Setter
public class OtherProduct extends AbstractEntity {
    @Column(unique = true, nullable = false, length = 50)
    private String name;
    @Column(nullable = false)
    private BigDecimal price;
    @Column(nullable = false, length = 20)
    private String kind;
}
