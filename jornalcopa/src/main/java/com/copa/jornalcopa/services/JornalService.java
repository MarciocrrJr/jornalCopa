package com.copa.jornalcopa.services;

import java.util.List;
import org.springframework.stereotype.Service;

import com.copa.jornalcopa.dtos.JornalResponse;
import com.copa.jornalcopa.entities.Jornal;
import com.copa.jornalcopa.mappers.JornalMapper;
import com.copa.jornalcopa.repositories.JornalRepository;
import jakarta.persistence.EntityNotFoundException; 

@Service
public class JornalService {

    private final JornalRepository repository;

    public JornalService(JornalRepository repository) {
        this.repository = repository;
    }

    public List<JornalResponse> findAll() {
        return repository.findAll()
                .stream()
                .map(JornalMapper::toDTO)
                .toList();
    }

    public Jornal findById(long id) {
        return repository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Jornal não encontrado"));
    }

    public void deleteById(Long id) {
        if (repository.existsById(id)) {
            repository.deleteById(id);
        } else {
            throw new EntityNotFoundException("Jornal não encontrado");
        }
    }

    public Jornal save(Jornal jornal) {
        return repository.save(jornal);
    }

    public void update(Jornal jornal, Long id) {
        Jornal j = repository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Jornal não encontrado"));

        j.setTitulo(jornal.getTitulo());
        j.setSubtitulo(jornal.getSubtitulo());
        j.setConteudo(jornal.getConteudo());
        j.setAutor(jornal.getAutor());
        j.setData(jornal.getData());

        repository.save(j);
    }
}