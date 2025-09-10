package com.projetodw.modelo;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
public class Aluno
{
    @Id
    private Long matricula;
    private String nome;
    private String email;

    // ********** Construtores **********

    public Aluno(){

    }

    public Aluno(String nome, String email){
        this.nome = nome;
        this.email = email;
    }

    // ********* Métodos do Tipo Get *********

    public Long getMatricula() { return matricula; }

    public String getNome() {
        return nome;
    }

    //  @Column(name="EMAIL")
    public String getEmail() {
        return email;
    }

    // ********* Métodos do Tipo Set *********

    public void setMatricula(Long matricula) {this.matricula = matricula;}

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setEmail(String email) {
        this.email = email;
    }

}


