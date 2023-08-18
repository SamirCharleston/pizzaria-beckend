package com.example.pizzariabackend.pizzariabackend.controllers;

import com.example.pizzariabackend.pizzariabackend.dtos.in.otherProductDtos.OtherProductInDTO;
import com.example.pizzariabackend.pizzariabackend.dtos.in.otherProductDtos.OtherProductUpdateDTO;
import com.example.pizzariabackend.pizzariabackend.dtos.out.otherProductDtos.OtherProductOutDTO;
import com.example.pizzariabackend.pizzariabackend.services.OtherProductService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@Controller
@RequestMapping(value = "/other-product")
public class OtherProductController{
    @Autowired
    OtherProductService otherProductService;
    @GetMapping
    public ResponseEntity<OtherProductOutDTO> findById(@RequestParam final Long id) {
        try {
            return ResponseEntity.ok(otherProductService.findById(id));
        } catch (Exception e) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Error: " + e.getMessage(), e);
        }
    }
    @GetMapping("/all")
    public ResponseEntity<List<OtherProductOutDTO>> findAll(){
        try {
            return ResponseEntity.ok((List<OtherProductOutDTO>) otherProductService.findAll());
        } catch (Exception e) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Error: " + e.getMessage());
        }
    }
    @PostMapping
    public ResponseEntity<String> register(@RequestBody @Valid final OtherProductInDTO body){
        try {
            return ResponseEntity.ok(otherProductService.register(body));
        }catch (Exception e) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Error: " + e.getMessage());
        }
    }
    @PutMapping
    public ResponseEntity<String> update(@RequestBody @Valid final OtherProductUpdateDTO body) {
        try {
            return ResponseEntity.ok(otherProductService.update(body));
        }catch (Exception e) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Error: " + e.getMessage());
        }
    }
    @DeleteMapping
    public ResponseEntity<String> delete(@RequestParam final Long id) {
        try {
            return ResponseEntity.ok(otherProductService.delete(id));
        } catch (Exception e) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Error: " + e.getMessage());
        }
    }
}
