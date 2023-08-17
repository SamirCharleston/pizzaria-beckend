package com.example.pizzariabackend.pizzariabackend.config.abstractClasses;

import com.example.pizzariabackend.pizzariabackend.config.abstractClasses.abstractDtos.AbstractIdDTO;
import com.example.pizzariabackend.pizzariabackend.config.abstractClasses.abstractDtos.AbstractInDTO;
import com.example.pizzariabackend.pizzariabackend.config.abstractClasses.abstractDtos.AbstractOutDTO;
import com.example.pizzariabackend.pizzariabackend.config.abstractClasses.abstractDtos.AbstractUpdateDTO;
import jakarta.persistence.EntityNotFoundException;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
@Service
@Transactional
//@MappedSuperclass
public class AbstractService <
        Repository extends MainRepository<ObjectEntity>,
        ObjectIdDTO extends AbstractIdDTO,
        ObjectInDTO extends AbstractInDTO,
        ObjectUpdateDTO extends AbstractUpdateDTO,
        ObjectOutDTO extends AbstractOutDTO,
        ObjectEntity extends  AbstractEntity> {
    @Autowired
    private Repository repository;
    @Autowired
    private ModelMapper modelMapper;
    public ObjectOutDTO findById(ObjectIdDTO object) throws EntityNotFoundException {
        ObjectEntity dataBaseEntity =  repository.findById(object.getId()).orElseThrow(() -> {
            throw new EntityNotFoundException("Can't found the id " + object.getId() + ".");
        });
        return (ObjectOutDTO) dataBaseEntity;
    }
    public List<ObjectEntity> findAll() throws EntityNotFoundException{
        List<ObjectEntity> objects = repository.findAll();
        if (objects == null || objects.isEmpty())
            throw new EntityNotFoundException("No objects found.");
        return objects;
    }
    public String register(ObjectInDTO object) throws DataIntegrityViolationException {
//        repository.save(object);
        return "Successfully registered.";
    }
    public String update(ObjectUpdateDTO object) throws DataIntegrityViolationException {
        Object dataBaseObject = repository.findById(object.getId()).orElseThrow(() -> {
            throw new EntityNotFoundException("Can't found the id " + object.getId() + ".");
        });
//        repository.save(object);
        return "Successfully updated.";
    }
    public String delete(Object object) throws EntityNotFoundException{
//        repository.delete(object);
        return "Successfully deleted.";
    }
}
