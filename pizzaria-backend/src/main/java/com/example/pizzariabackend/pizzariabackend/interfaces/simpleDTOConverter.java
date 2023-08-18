package com.example.pizzariabackend.pizzariabackend.interfaces;

public interface simpleDTOConverter {
    public <ObjectDTO, ObjectEntity> ObjectDTO convertToDTO(ObjectEntity objectEntity);
    public <ObjectDTO, ObjectEntity> ObjectEntity convertToEntity(ObjectDTO objectDTO);
}
