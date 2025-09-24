package com.apirestful;

import com.apirestful.model.Aluno;
import com.apirestful.model.Inscricao;
import com.apirestful.model.Professor;
import com.apirestful.model.Turma;
import com.apirestful.repository.AlunoRepository;
import com.apirestful.repository.InscricaoRepository;
import com.apirestful.repository.ProfessorRepository;
import com.apirestful.repository.TurmaRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.time.LocalDateTime;

@RequiredArgsConstructor
@SpringBootApplication
public class ApirestfulApplication implements CommandLineRunner {

    private final ProfessorRepository professorRepository;
    private final AlunoRepository alunoRepository;
    private final TurmaRepository turmaRepository;
    private final InscricaoRepository inscricaoRepository;

    public static void main(String[] args) {
        SpringApplication.run(ApirestfulApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {

        // Professores
        Professor p1 = new Professor("Carlos Silva", "carlos@universidade.com");
        Professor p2 = new Professor("Mariana Souza", "mariana@universidade.com");
        professorRepository.save(p1);
        professorRepository.save(p2);

        // Alunos
        Aluno a1 = new Aluno("João", "joao@email.com");
        Aluno a2 = new Aluno("Ana", "ana@email.com");
        alunoRepository.save(a1);
        alunoRepository.save(a2);

        // Turmas
        Turma t1 = new Turma(2025, "1º semestre", p1);
        Turma t2 = new Turma(2025, "2º semestre", p2);
        turmaRepository.save(t1);
        turmaRepository.save(t2);

        // Inscrições
        Inscricao i1 = new Inscricao(LocalDateTime.now(), a1, t1);
        Inscricao i2 = new Inscricao(LocalDateTime.now(), a2, t2);
        inscricaoRepository.save(i1);
        inscricaoRepository.save(i2);
    }
}
