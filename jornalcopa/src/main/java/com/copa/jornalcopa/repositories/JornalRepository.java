package com.copa.jornalcopa.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.copa.jornalcopa.entities.Jornal;

public interface JornalRepository extends JpaRepository<Jornal, Long> {
    
}
