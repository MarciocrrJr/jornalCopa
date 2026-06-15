package com.copa.jornalcopa.controllers;

import java.net.URI;
import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.copa.jornalcopa.dtos.JornalRequest;
import com.copa.jornalcopa.dtos.JornalResponse;
import com.copa.jornalcopa.entities.Jornal;
import com.copa.jornalcopa.mappers.JornalMapper;
import com.copa.jornalcopa.services.JornalService;

import jakarta.validation.Valid;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

@RestController
@RequestMapping("/jornal")
public class JornalController {

    private final JornalService service;

    public JornalController(JornalService service) {
        this.service = service;
    }

    @GetMapping
    public ResponseEntity<List<JornalResponse>> getAll(){
        return ResponseEntity.ok(service.findAll());
    }
    
    @GetMapping("/{id}")
    public ResponseEntity<JornalResponse> getById(@PathVariable long id){
        Jornal jornal = service.findById(id);
        return ResponseEntity.ok(JornalMapper.toDTO(jornal));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteById(@PathVariable Long id) {
        service.deleteById(id);
        return ResponseEntity.noContent().build();
    }

    @PostMapping
    public ResponseEntity<JornalResponse> save(@Valid @RequestBody JornalRequest jornalRequest) {
        Jornal jornal = JornalMapper.toEntity(jornalRequest);

        Jornal j = service.save(jornal);
        JornalResponse response = JornalMapper.toDTO(j);

        URI location = ServletUriComponentsBuilder
                        .fromCurrentRequest()
                        .path("/{id}")
                        .buildAndExpand(response.id())
                        .toUri();
                        
        return ResponseEntity.created(location).body(response);
    }
    
    @PutMapping("/{id}")
    public ResponseEntity<Void> update(@Valid @RequestBody JornalRequest jornalRequest, @PathVariable Long id) {
        Jornal jornalDadosNovos = JornalMapper.toEntity(jornalRequest);

        service.update(jornalDadosNovos, id);
        return ResponseEntity.noContent().build();
    }
}