package com.apirestful.controller;

import com.apirestful.model.Professor;
import com.apirestful.service.ProfessorService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/professores")
public class ProfessorController {
    private final ProfessorService service;

    public ProfessorController(ProfessorService service) {
        this.service = service;
    }

    @GetMapping
    public List<Professor> getAll() {
        return service.getAll();
    }

    @GetMapping("/{id}")
    public Professor getById(@PathVariable Long id) {
        return service.getById(id);
    }

    @PostMapping
    public Professor create(@RequestBody Professor professor) {
        return service.create(professor);
    }

    @PutMapping("/{id}")
    public Professor update(@PathVariable Long id, @RequestBody Professor professor) {
        return service.update(id, professor);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        service.delete(id);
    }
}
