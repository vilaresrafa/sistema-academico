package com.apirestful.service;

import com.apirestful.model.Professor;
import com.apirestful.repository.ProfessorRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProfessorService {
    private final ProfessorRepository repository;

    public ProfessorService(ProfessorRepository repository) {
        this.repository = repository;
    }

    public List<Professor> getAll() {
        return repository.findAll();
    }

    public Professor getById(Long id) {
        return repository.findById(id).orElseThrow();
    }

    public Professor create(Professor professor) {
        return repository.save(professor);
    }

    public Professor update(Long id, Professor professor) {
        professor.setId(id);
        return repository.save(professor);
    }

    public void delete(Long id) {
        repository.deleteById(id);
    }
}
