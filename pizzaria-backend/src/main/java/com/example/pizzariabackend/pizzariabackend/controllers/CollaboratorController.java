package com.example.pizzariabackend.pizzariabackend.controllers;

import com.example.pizzariabackend.pizzariabackend.dtos.in.collaboratorDtos.CollaboratorInDTO;
import com.example.pizzariabackend.pizzariabackend.dtos.in.collaboratorDtos.CollaboratorUpdateDTO;
import com.example.pizzariabackend.pizzariabackend.dtos.out.collaboratorDtos.CollaboratorOutDTO;
import com.example.pizzariabackend.pizzariabackend.services.CollaboratorService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@Controller
@RequestMapping(value = "/collaborator")
public class CollaboratorController{
    @Autowired
    CollaboratorService collaboratorService;
    @GetMapping
    public ResponseEntity<CollaboratorOutDTO> findById(@RequestParam final Long id) {
        try {
            return ResponseEntity.ok(collaboratorService.findById(id));
        } catch (Exception e) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Error: " + e.getMessage(), e);
        }
    }
    @GetMapping("/all")
    public ResponseEntity<List<CollaboratorOutDTO>> findAll(){
        try {
            return ResponseEntity.ok((List<CollaboratorOutDTO>) collaboratorService.findAll());
        } catch (Exception e) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Error: " + e.getMessage());
        }
    }
    @PostMapping
    public ResponseEntity<String> register(@RequestBody @Valid final CollaboratorInDTO body){
        try {
            return ResponseEntity.ok(collaboratorService.register(body));
        }catch (Exception e) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Error: " + e.getMessage());
        }
    }
    @PutMapping
    public ResponseEntity<String> update(@RequestBody @Valid final CollaboratorUpdateDTO body) {
        try {
            return ResponseEntity.ok(collaboratorService.update(body));
        }catch (Exception e) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Error: " + e.getMessage());
        }
    }
    @DeleteMapping
    public ResponseEntity<String> delete(@RequestParam final Long id) {
        try {
            return ResponseEntity.ok(collaboratorService.delete(id));
        } catch (Exception e) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Error: " + e.getMessage());
        }
    }
}
