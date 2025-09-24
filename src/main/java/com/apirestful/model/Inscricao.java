package com.apirestful.model;

import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDateTime;

@Entity
@Data
public class Inscricao {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private LocalDateTime dataHora;

    @ManyToOne
    private Aluno aluno;

    @ManyToOne
    private Turma turma;

    public Inscricao() {}

    public Inscricao(LocalDateTime dataHora, Aluno aluno, Turma turma) {
        this.dataHora = dataHora;
        this.aluno = aluno;
        this.turma = turma;
    }

}
