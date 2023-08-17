package com.example.pizzariabackend.pizzariabackend.config.abstractClasses;

import org.springframework.context.annotation.Primary;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
@Primary
@Repository
public interface MainRepository<ObjectEntity extends AbstractEntity> extends JpaRepository<ObjectEntity, Long>{
}