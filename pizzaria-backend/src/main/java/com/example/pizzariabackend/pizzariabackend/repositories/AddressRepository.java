package com.example.pizzariabackend.pizzariabackend.repositories;

import com.example.pizzariabackend.pizzariabackend.dtos.in.addressDtos.AddressUpdateDTO;
import com.example.pizzariabackend.pizzariabackend.entities.Address;
import com.example.pizzariabackend.pizzariabackend.abstractClasses.interfaces.MainRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface AddressRepository extends MainRepository<Address> {
//    @Query(value = "UPDATE Address SET a. WHERE a.id = :address.id")
//    void update(@Param("address")AddressUpdateDTO address);
}