package com.example.pizzariabackend.pizzariabackend.controllers;

import com.example.pizzariabackend.pizzariabackend.dtos.in.pizzaDtos.PizzaInDTO;
import com.example.pizzariabackend.pizzariabackend.dtos.in.pizzaDtos.PizzaUpdateDTO;
import com.example.pizzariabackend.pizzariabackend.dtos.out.pizzaDtos.PizzaOutDTO;
import com.example.pizzariabackend.pizzariabackend.services.PizzaService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;
import java.util.List;

@Controller
@RequestMapping(value = "/pizza")
public class PizzaController{
    @Autowired
    PizzaService pizzaService;
    @GetMapping
    public ResponseEntity<PizzaOutDTO> findById(@RequestParam final Long id) {
        try {
            return ResponseEntity.ok(pizzaService.findById(id));
        } catch (Exception e) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Error: " + e.getMessage(), e);
        }
    }
    @GetMapping("/all")
    public ResponseEntity<List<PizzaOutDTO>> findAll(){
        try {
            return ResponseEntity.ok((List<PizzaOutDTO>) pizzaService.findAll());
        } catch (Exception e) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Error: " + e.getMessage());
        }
    }
    @PostMapping
    public ResponseEntity<String> register(@RequestBody @Valid final PizzaInDTO body){
        try {
            return ResponseEntity.ok(pizzaService.register(body));
        }catch (Exception e) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Error: " + e.getMessage());
        }
    }
    @PutMapping
    public ResponseEntity<String> update(@RequestBody @Valid final PizzaUpdateDTO body) {
        try {
            return ResponseEntity.ok(pizzaService.update(body));
        }catch (Exception e) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Error: " + e.getMessage());
        }
    }
    @DeleteMapping
    public ResponseEntity<String> delete(@RequestParam final Long id) {
        try {
            return ResponseEntity.ok(pizzaService.delete(id));
        } catch (Exception e) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Error: " + e.getMessage());
        }
    }
}