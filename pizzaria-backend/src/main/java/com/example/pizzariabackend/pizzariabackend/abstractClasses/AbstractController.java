package com.example.pizzariabackend.pizzariabackend.abstractClasses;

import com.example.pizzariabackend.pizzariabackend.abstractClasses.abstractDtos.AbstractIdDTO;
import com.example.pizzariabackend.pizzariabackend.abstractClasses.abstractDtos.AbstractInDTO;
import com.example.pizzariabackend.pizzariabackend.abstractClasses.abstractDtos.AbstractOutDTO;
import com.example.pizzariabackend.pizzariabackend.abstractClasses.abstractDtos.AbstractUpdateDTO;
import jakarta.persistence.MappedSuperclass;
import org.springframework.beans.factory.annotation.*;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@CrossOrigin(origins = "http://localhost:3000")
@RestController
@MappedSuperclass
public abstract class AbstractController<
        Service extends AbstractService,
        ObjectIdDTO extends AbstractIdDTO,
        ObjectInDTO extends AbstractInDTO,
        ObjectUpdateDTO extends AbstractUpdateDTO,
        ObjectOutDTO extends AbstractOutDTO> {
    @Autowired
    protected Service service;
    @GetMapping
    public ResponseEntity<ObjectOutDTO> findById(@RequestBody final ObjectIdDTO object) {
        try {
            return ResponseEntity.ok((ObjectOutDTO) this.service.findById(object));
        } catch (Exception e) {
            throw new RuntimeException("Error: " + e.getMessage());
        }
    }
    @GetMapping("/all")
    public ResponseEntity<List<ObjectOutDTO>> findAll(){
        try {
            return ResponseEntity.ok(this.service.findAll());
        } catch (Exception e) {
            throw new RuntimeException("Error: " + e.getMessage());
        }
    }
    @PostMapping
    public ResponseEntity<String> register(@RequestBody final ObjectInDTO body){
        try {
            return ResponseEntity.ok(service.register(body));
        }catch (IllegalArgumentException e) {
            throw new RuntimeException("Error: " + e.getMessage());
        }
    }
    @PutMapping
    public ResponseEntity<String> update(@RequestBody final ObjectUpdateDTO body) {
        try {
            return ResponseEntity.ok(service.update(body));
        }catch (Exception e) {
            throw new RuntimeException("Error: " + e.getMessage());
        }
    }
    @DeleteMapping
    public ResponseEntity<String> delete(@RequestBody final ObjectIdDTO body) {
        try {
            return ResponseEntity.ok(service.delete(body));
        } catch (Exception e) {
            throw new RuntimeException("Error: " + e.getMessage());
        }
    }
}
