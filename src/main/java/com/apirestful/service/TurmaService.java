package com.apirestful.service;

import com.apirestful.model.Turma;
import com.apirestful.repository.TurmaRepository;
import org.springframework.stereotype.Service;

@Service
public class TurmaService {
    private final TurmaRepository repository;

    public TurmaService(TurmaRepository repository) {
        this.repository = repository;
    }

    public Turma create(Turma turma) {
        return repository.save(turma);
    }

    public void delete(Long id) {
        repository.deleteById(id);
    }
}
