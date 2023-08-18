package com.example.pizzariabackend.pizzariabackend.abstractClasses;

import com.example.pizzariabackend.pizzariabackend.abstractClasses.abstractDtos.AbstractIdDTO;
import com.example.pizzariabackend.pizzariabackend.abstractClasses.abstractDtos.AbstractInDTO;
import com.example.pizzariabackend.pizzariabackend.abstractClasses.abstractDtos.AbstractOutDTO;
import com.example.pizzariabackend.pizzariabackend.abstractClasses.abstractDtos.AbstractUpdateDTO;
import com.example.pizzariabackend.pizzariabackend.interfaces.simpleDTOConverter;
import com.example.pizzariabackend.pizzariabackend.interfaces.MainRepository;
import jakarta.persistence.EntityNotFoundException;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
@Transactional
//@MappedSuperclass
public abstract class AbstractService <
        Repository extends MainRepository<ObjectEntity>,
        ObjectIdDTO extends AbstractIdDTO,
        ObjectInDTO extends AbstractInDTO,
        ObjectUpdateDTO extends AbstractUpdateDTO,
        ObjectOutDTO extends AbstractOutDTO,
        ObjectEntity extends  AbstractEntity> implements simpleDTOConverter {
    @Autowired
    private Repository repository;
    @Autowired
    private ModelMapper modelMapper;

    public ObjectOutDTO findById(ObjectIdDTO object) throws EntityNotFoundException {
        ObjectEntity dataBaseEntity = repository.findById(object.getId()).orElseThrow(() -> {
            throw new EntityNotFoundException("Can't found the id " + object.getId() + ".");
        });
        return this.convertToDTO(dataBaseEntity);
    }
    public List<ObjectOutDTO> findAll() throws EntityNotFoundException{
        List<ObjectEntity> objects = repository.findAll();
        if (objects == null || objects.isEmpty())
            throw new EntityNotFoundException("No objects found.");
        return objects.stream()
                .map(e -> (ObjectOutDTO) this.convertToDTO(e))
                .collect(Collectors.toList());
    }
    public String register(ObjectInDTO object) throws DataIntegrityViolationException {
        repository.save(this.convertToEntity(object));
        return "Successfully registered.";
    }
    public String update(ObjectUpdateDTO object) throws DataIntegrityViolationException {
        ObjectEntity dataBaseObject = repository.findById(object.getId()).orElseThrow(() -> {
            throw new EntityNotFoundException("Can't found the id " + object.getId() + ".");
        });
        object.setId(dataBaseObject.getId());
        repository.save(this.convertToEntity(object));
        return "Successfully updated.";
    }
    public String delete(ObjectIdDTO object) throws EntityNotFoundException{
        ObjectEntity dataBaseObject = repository.findById(object.getId()).orElseThrow(() -> {
            throw new EntityNotFoundException("Can't found the id " + object.getId() + ".");
        });
        repository.deleteById(object.getId());
        return "Successfully deleted.";
    }
}
