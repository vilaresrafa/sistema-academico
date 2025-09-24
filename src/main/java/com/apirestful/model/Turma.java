package com.apirestful.model;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
public class Turma {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private int ano;
    private String periodo;

    @ManyToOne
    private Professor professor;

    public Turma() {}

    public Turma(int ano, String periodo, Professor professor) {
        this.ano = ano;
        this.periodo = periodo;
        this.professor = professor;
    }
}
