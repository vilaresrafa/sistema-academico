package com.apirestful.controller;

import com.apirestful.model.Aluno;
import com.apirestful.service.AlunoService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/alunos")
public class AlunoController {
    private final AlunoService service;

    public AlunoController(AlunoService service) {
        this.service = service;
    }

    @GetMapping
    public List<Aluno> getAll() {
        return service.getAll();
    }

    @GetMapping("/{id}")
    public Aluno getById(@PathVariable Long id) {
        return service.getById(id);
    }

    @PostMapping
    public Aluno create(@RequestBody Aluno aluno) {
        return service.create(aluno);
    }

    @PutMapping("/{id}")
    public Aluno update(@PathVariable Long id, @RequestBody Aluno aluno) {
        return service.update(id, aluno);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        service.delete(id);
    }
}
