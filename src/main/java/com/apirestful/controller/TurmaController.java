package com.apirestful.controller;

import com.apirestful.model.Turma;
import com.apirestful.service.TurmaService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/turmas")
public class TurmaController {
    private final TurmaService service;

    public TurmaController(TurmaService service) {
        this.service = service;
    }

    @PostMapping
    public Turma create(@RequestBody Turma turma) {
        return service.create(turma);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        service.delete(id);
    }
}
