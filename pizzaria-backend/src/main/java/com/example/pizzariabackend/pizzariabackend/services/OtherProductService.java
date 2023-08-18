package com.example.pizzariabackend.pizzariabackend.services;

import com.example.pizzariabackend.pizzariabackend.dtos.in.otherProductDtos.OtherProductIdDTO;
import com.example.pizzariabackend.pizzariabackend.dtos.in.otherProductDtos.OtherProductInDTO;
import com.example.pizzariabackend.pizzariabackend.dtos.in.otherProductDtos.OtherProductUpdateDTO;
import com.example.pizzariabackend.pizzariabackend.dtos.out.otherProductDtos.OtherProductOutDTO;
import com.example.pizzariabackend.pizzariabackend.entities.OtherProduct;
import com.example.pizzariabackend.pizzariabackend.repositories.OtherProductRepository;
import com.example.pizzariabackend.pizzariabackend.abstractClasses.AbstractService;

public class OtherProductService extends AbstractService<
        OtherProductRepository,
        OtherProductIdDTO,
        OtherProductInDTO,
        OtherProductUpdateDTO,
        OtherProductOutDTO,
        OtherProduct> {
    @Override
    public <ObjectDTO, ObjectEntity> ObjectDTO convertToDTO(ObjectEntity objectEntity) {
        return null;
    }

    @Override
    public <ObjectDTO, ObjectEntity> ObjectEntity convertToEntity(ObjectDTO objectDTO) {
        return null;
    }
}
