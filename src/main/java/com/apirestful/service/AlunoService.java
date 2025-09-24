package com.apirestful.service;

import com.apirestful.model.Aluno;
import com.apirestful.repository.AlunoRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AlunoService {
    private final AlunoRepository repository;

    public AlunoService(AlunoRepository repository) {
        this.repository = repository;
    }

    public List<Aluno> getAll() {
        return repository.findAll();
    }

    public Aluno getById(Long id) {
        return repository.findById(id).orElseThrow();
    }

    public Aluno create(Aluno aluno) {
        return repository.save(aluno);
    }

    public Aluno update(Long id, Aluno aluno) {
        aluno.setId(id);
        return repository.save(aluno);
    }

    public void delete(Long id) {
        repository.deleteById(id);
    }
}
