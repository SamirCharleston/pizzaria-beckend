package com.example.pizzariabackend.pizzariabackend.services;

import com.example.pizzariabackend.pizzariabackend.dtos.in.addressDtos.AddressIdDTO;
import com.example.pizzariabackend.pizzariabackend.dtos.in.addressDtos.AddressInDTO;
import com.example.pizzariabackend.pizzariabackend.dtos.in.addressDtos.AddressUpdateDTO;
import com.example.pizzariabackend.pizzariabackend.dtos.out.addressDtos.AddressOutDTO;
import com.example.pizzariabackend.pizzariabackend.entities.Address;
import com.example.pizzariabackend.pizzariabackend.repositories.AddressRepository;
import com.example.pizzariabackend.pizzariabackend.abstractClasses.AbstractService;

public class AddressService extends AbstractService<
        AddressRepository,
        AddressIdDTO,
        AddressInDTO,
        AddressUpdateDTO,
        AddressOutDTO,
        Address>{
    @Override
    public <ObjectDTO, ObjectEntity> ObjectDTO convertToDTO(ObjectEntity objectEntity) {
        return null;
    }

    @Override
    public <ObjectDTO, ObjectEntity> ObjectEntity convertToEntity(ObjectDTO objectDTO) {
        return null;
    }
}
