package com.projetodw.modelo;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
public class Aluno
{
    private Long Id;
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
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="Id")
    public Long getId() { return Id; }

    public String getNome() {
        return nome;
    }

    //  @Column(name="EMAIL")
    public String getEmail() {
        return email;
    }

    // ********* Métodos do Tipo Set *********

    public void setId(Long Id) {this.Id = Id;}

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setEmail(String email) {
        this.email = email;
    }

}


