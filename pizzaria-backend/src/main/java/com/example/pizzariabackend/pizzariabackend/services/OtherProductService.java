package com.example.pizzariabackend.pizzariabackend.services;

import com.example.pizzariabackend.pizzariabackend.dtos.in.otherProductDtos.OtherProductIdDTO;
import com.example.pizzariabackend.pizzariabackend.dtos.in.otherProductDtos.OtherProductInDTO;
import com.example.pizzariabackend.pizzariabackend.dtos.in.otherProductDtos.OtherProductUpdateDTO;
import com.example.pizzariabackend.pizzariabackend.dtos.out.otherProductDtos.OtherProductOutDTO;
import com.example.pizzariabackend.pizzariabackend.entities.OtherProduct;
import com.example.pizzariabackend.pizzariabackend.repositories.OtherProductRepository;
import com.example.pizzariabackend.pizzariabackend.settings.abstractClasses.AbstractService;
import org.springframework.stereotype.Service;

@Service
public class OtherProductService extends AbstractService<
        OtherProductRepository,
        OtherProductIdDTO,
        OtherProductInDTO,
        OtherProductUpdateDTO,
        OtherProductOutDTO,
        OtherProduct> {
}
