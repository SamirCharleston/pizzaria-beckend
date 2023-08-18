package com.example.pizzariabackend.pizzariabackend.controllers;

import com.example.pizzariabackend.pizzariabackend.dtos.in.orderDtos.OrderInDTO;
import com.example.pizzariabackend.pizzariabackend.dtos.in.orderDtos.OrderUpdateDTO;
import com.example.pizzariabackend.pizzariabackend.dtos.out.orderDtos.OrderOutDTO;
import com.example.pizzariabackend.pizzariabackend.services.OrderService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@Controller
@RequestMapping(value = "/order")
public class OrderController {
    @Autowired
    OrderService orderService;
    @GetMapping
    public ResponseEntity<OrderOutDTO> findById(@RequestParam final Long id) {
        try {
            return ResponseEntity.ok(orderService.findById(id));
        } catch (Exception e) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Error: " + e.getMessage(), e);
        }
    }
    @GetMapping("/all")
    public ResponseEntity<List<OrderOutDTO>> findAll(){
        try {
            return ResponseEntity.ok((List<OrderOutDTO>) orderService.findAll());
        } catch (Exception e) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Error: " + e.getMessage());
        }
    }
    @PostMapping
    public ResponseEntity<String> register(@RequestBody @Valid final OrderInDTO body){
        try {
            return ResponseEntity.ok(orderService.register(body));
        }catch (Exception e) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Error: " + e.getMessage());
        }
    }
    @PutMapping
    public ResponseEntity<String> update(@RequestBody @Valid final OrderUpdateDTO body) {
        try {
            return ResponseEntity.ok(orderService.update(body));
        }catch (Exception e) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Error: " + e.getMessage());
        }
    }
    @DeleteMapping
    public ResponseEntity<String> delete(@RequestParam final Long id) {
        try {
            return ResponseEntity.ok(orderService.delete(id));
        } catch (Exception e) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Error: " + e.getMessage());
        }
    }
}
