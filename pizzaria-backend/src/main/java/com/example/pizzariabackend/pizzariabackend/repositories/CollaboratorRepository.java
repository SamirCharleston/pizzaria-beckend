package com.example.pizzariabackend.pizzariabackend.repositories;

import com.example.pizzariabackend.pizzariabackend.entities.Collaborator;
import com.example.pizzariabackend.pizzariabackend.abstractClasses.interfaces.MainRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;


public interface CollaboratorRepository extends MainRepository<Collaborator> {
    @Query ("SELECT c FROM Collaborator c WHERE c.cpf = :cpf")
    Collaborator findByCpf(@Param("cpf") String cpf);
}