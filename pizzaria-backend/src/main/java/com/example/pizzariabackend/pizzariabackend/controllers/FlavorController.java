package com.example.pizzariabackend.pizzariabackend.controllers;

import com.example.pizzariabackend.pizzariabackend.dtos.in.flavorDtos.FlavorInDTO;
import com.example.pizzariabackend.pizzariabackend.dtos.in.flavorDtos.FlavorUpdateDTO;
import com.example.pizzariabackend.pizzariabackend.dtos.out.flavorDtos.FlavorOutDTO;
import com.example.pizzariabackend.pizzariabackend.services.FlavorService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@Controller
@RequestMapping(value = "/flavor")
public class FlavorController{
    @Autowired
    FlavorService flavorService;
    @GetMapping
    public ResponseEntity<FlavorOutDTO> findById(@RequestParam final Long id) {
        try {
            return ResponseEntity.ok(flavorService.findById(id));
        } catch (Exception e) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Error: " + e.getMessage(), e);
        }
    }
    @GetMapping("/all")
    public ResponseEntity<List<FlavorOutDTO>> findAll(){
        try {
            return ResponseEntity.ok((List<FlavorOutDTO>) flavorService.findAll());
        } catch (Exception e) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Error: " + e.getMessage());
        }
    }
    @PostMapping
    public ResponseEntity<String> register(@RequestBody @Valid final FlavorInDTO body){
        try {
            return ResponseEntity.ok(flavorService.register(body));
        }catch (Exception e) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Error: " + e.getMessage());
        }
    }
    @PutMapping
    public ResponseEntity<String> update(@RequestBody @Valid final FlavorUpdateDTO body) {
        try {
            return ResponseEntity.ok(flavorService.update(body));
        }catch (Exception e) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Error: " + e.getMessage());
        }
    }
    @DeleteMapping
    public ResponseEntity<String> delete(@RequestParam final Long id) {
        try {
            return ResponseEntity.ok(flavorService.delete(id));
        } catch (Exception e) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Error: " + e.getMessage());
        }
    }
}
