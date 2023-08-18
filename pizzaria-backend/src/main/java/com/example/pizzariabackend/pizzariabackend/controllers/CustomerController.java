package com.example.pizzariabackend.pizzariabackend.controllers;

import com.example.pizzariabackend.pizzariabackend.dtos.in.customerDtos.CustomerIdDTO;
import com.example.pizzariabackend.pizzariabackend.dtos.in.customerDtos.CustomerInDTO;
import com.example.pizzariabackend.pizzariabackend.dtos.in.customerDtos.CustomerUpdateDTO;
import com.example.pizzariabackend.pizzariabackend.dtos.in.customerDtos.CustomerInDTO;
import com.example.pizzariabackend.pizzariabackend.dtos.in.customerDtos.CustomerUpdateDTO;
import com.example.pizzariabackend.pizzariabackend.dtos.out.customerDtos.CustomerOutDTO;
import com.example.pizzariabackend.pizzariabackend.abstractClasses.AbstractController;
import com.example.pizzariabackend.pizzariabackend.abstractClasses.AbstractService;
import com.example.pizzariabackend.pizzariabackend.dtos.out.customerDtos.CustomerOutDTO;
import com.example.pizzariabackend.pizzariabackend.services.CustomerService;
import com.example.pizzariabackend.pizzariabackend.services.CustomerService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@Controller
@RequestMapping(value = "/customer")
public class CustomerController{
    @Autowired
    CustomerService customerService;
    @GetMapping
    public ResponseEntity<CustomerOutDTO> findById(@RequestParam final Long id) {
        try {
            return ResponseEntity.ok(customerService.findById(id));
        } catch (Exception e) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Error: " + e.getMessage(), e);
        }
    }
    @GetMapping("/all")
    public ResponseEntity<List<CustomerOutDTO>> findAll(){
        try {
            return ResponseEntity.ok((List<CustomerOutDTO>) customerService.findAll());
        } catch (Exception e) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Error: " + e.getMessage());
        }
    }
    @PostMapping
    public ResponseEntity<String> register(@RequestBody @Valid final CustomerInDTO body){
        try {
            return ResponseEntity.ok(customerService.register(body));
        }catch (Exception e) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Error: " + e.getMessage());
        }
    }
    @PutMapping
    public ResponseEntity<String> update(@RequestBody @Valid final CustomerUpdateDTO body) {
        try {
            return ResponseEntity.ok(customerService.update(body));
        }catch (Exception e) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Error: " + e.getMessage());
        }
    }
    @DeleteMapping
    public ResponseEntity<String> delete(@RequestParam final Long id) {
        try {
            return ResponseEntity.ok(customerService.delete(id));
        } catch (Exception e) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Error: " + e.getMessage());
        }
    }
}
