package com.example.pizzariabackend.pizzariabackend.abstractClasses.interfaces;

public interface simpleDTOConverter {
    public <ObjectOutDTO, ObjectEntity> ObjectOutDTO convertToDTO(ObjectEntity objectEntity);
    public <ObjectDTO, ObjectEntity> ObjectEntity convertToEntity(ObjectDTO objectDTO);
}
