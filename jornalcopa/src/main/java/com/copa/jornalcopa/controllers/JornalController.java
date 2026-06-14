package com.copa.jornalcopa.controllers;

import java.net.URI;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.copa.jornalcopa.entities.Jornal;
import com.copa.jornalcopa.services.JornalService;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;



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

    @DeleteMapping("{id}")
    public ResponseEntity<Void> deleteById(@PathVariable Long id) {
        service.deleteById(id);
        return ResponseEntity.noContent().build();
    }

    @PostMapping
    public ResponseEntity<Jornal> save(@RequestBody Jornal jornal) {
        Jornal j = service.save(jornal);

        URI location = ServletUriComponentsBuilder
                        .fromCurrentRequest()
                        .path("/{id}")
                        .buildAndExpand(j.getId())
                        .toUri();
        return ResponseEntity.created(location).body(j);
    }
    
    @PutMapping("{id}")
    public ResponseEntity<Void> update(@RequestBody Jornal jornal, @PathVariable Long id) {

        service.update(jornal, id);
        return ResponseEntity.noContent().build();
    }
}
