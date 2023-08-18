package com.example.pizzariabackend.pizzariabackend.controllers;

import com.example.pizzariabackend.pizzariabackend.abstractClasses.abstractDtos.AbstractOutDTO;
import com.example.pizzariabackend.pizzariabackend.dtos.in.flavorDtos.FlavorIdDTO;
import com.example.pizzariabackend.pizzariabackend.dtos.in.flavorDtos.FlavorInDTO;
import com.example.pizzariabackend.pizzariabackend.dtos.in.flavorDtos.FlavorUpdateDTO;
import com.example.pizzariabackend.pizzariabackend.dtos.out.flavorDtos.FlavorOutDTO;
import com.example.pizzariabackend.pizzariabackend.abstractClasses.AbstractController;
import com.example.pizzariabackend.pizzariabackend.services.FlavorService;
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
//    @GetMapping("/all")
//    public ResponseEntity<List<ObjectOutDTO>> findAll(){
//        try {
//            return ResponseEntity.ok((List<ObjectOutDTO>) this.service.findAll());
//        } catch (Exception e) {
//            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Error: " + e.getMessage());
//        }
//    }
    @PostMapping
    public ResponseEntity<String> register(@RequestBody final FlavorInDTO body){
        try {
            return ResponseEntity.ok(flavorService.register(body));
        }catch (Exception e) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Error: " + e.getMessage());
        }
    }
//    @PutMapping
//    public ResponseEntity<String> update(@RequestBody final ObjectUpdateDTO body) {
//        try {
//            return ResponseEntity.ok(service.update(body));
//        }catch (Exception e) {
//            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Error: " + e.getMessage());
//        }
//    }
//    @DeleteMapping
//    public ResponseEntity<String> delete(@RequestParam final Long id) {
//        try {
//            return ResponseEntity.ok(service.delete(id));
//        } catch (Exception e) {
//            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Error: " + e.getMessage());
//        }
//    }
}
