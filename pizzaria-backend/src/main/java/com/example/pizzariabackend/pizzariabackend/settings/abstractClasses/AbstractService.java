package com.example.pizzariabackend.pizzariabackend.settings.abstractClasses;

import com.example.pizzariabackend.pizzariabackend.settings.abstractClasses.abstractDtos.AbstractIdDTO;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.transaction.annotation.Transactional;
import java.util.List;
@Transactional
public class AbstractService <Repository extends JpaRepository<Object, Long>,
        ObjectIdDTO extends AbstractIdDTO,
        ObjectInDTO,
        ObjectUpdateDTO extends AbstractIdDTO> {
    @Autowired
    private Repository repository;
    public Object findById(ObjectIdDTO object) throws EntityNotFoundException{
        return repository.findById(object.getId()).orElseThrow(() -> {
            throw new EntityNotFoundException("Can't found the id " + object.getId() + ".");
        });
    }
    public List<Object> findAll() throws EntityNotFoundException{
        List<Object> objects = repository.findAll();
        if (objects == null || objects.isEmpty())
            throw new EntityNotFoundException("No objects found.");
        return objects;
    }
    public String register(ObjectInDTO object) throws DataIntegrityViolationException {
        repository.save(object);
        return "Successfully registered.";
    }
    public String update(ObjectUpdateDTO object) throws DataIntegrityViolationException {
        Object dataBaseObject = repository.findById(object.getId()).orElseThrow(() -> {
            throw new EntityNotFoundException("Can't found the id " + object.getId() + ".");
        });
        repository.save(object);
        return "Successfully updated.";
    }
    public String delete(Object object) throws EntityNotFoundException{
        repository.delete(object);
        return "Successfully deleted.";
    }
}
