package com.apirestful.service;

import com.apirestful.model.Inscricao;
import com.apirestful.repository.InscricaoRepository;
import org.springframework.stereotype.Service;

@Service
public class InscricaoService {
    private final InscricaoRepository repository;

    public InscricaoService(InscricaoRepository repository) {
        this.repository = repository;
    }

    public Inscricao create(Inscricao inscricao) {
        return repository.save(inscricao);
    }

    public void delete(Long id) {
        repository.deleteById(id);
    }
}
