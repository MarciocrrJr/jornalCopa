package com.copa.jornalcopa.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.copa.jornalcopa.entities.Jornal;
import com.copa.jornalcopa.services.JornalService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;


@RestController
@RequestMapping("/jornal")

public class JornalController {
    @Autowired
    private JornalService service;

    @GetMapping
    public ResponseEntity<List<Jornal>> getAll(){
        return ResponseEntity.ok(service.findAll());
    }
    
    @GetMapping("{id}")
    public ResponseEntity<Jornal> getById(@PathVariable long id){
            return ResponseEntity.ok(service.findById(id));
    }
}
