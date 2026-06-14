package com.copa.jornalcopa.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.copa.jornalcopa.entities.Jornal;
import com.copa.jornalcopa.repositories.JornalRepository;

import jakarta.persistence.EntityNotFoundException; 

@Service
public class JornalService {

    @Autowired
    private JornalRepository jornalRepository;

    public List<Jornal> findAll() {
        return jornalRepository.findAll();
    }

    public Jornal findById(long id) {
        return jornalRepository.findById(id)
                            .orElseThrow(() -> new EntityNotFoundException());
    }
}
