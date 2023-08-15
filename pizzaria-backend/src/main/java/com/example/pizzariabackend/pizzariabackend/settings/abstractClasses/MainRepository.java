package com.example.pizzariabackend.pizzariabackend.settings.abstractClasses;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MainRepository<ObjectEntity extends AbstractEntity> extends JpaRepository<ObjectEntity, Long> {
}
