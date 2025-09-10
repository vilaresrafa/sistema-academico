package com.projetodw.dao;

import com.projetodw.excecao.AlunoNaoEncontradoException;
import com.projetodw.modelo.Aluno;

import java.util.List;


public interface AlunoDAO
{
    long inclui(Aluno umAluno);
    void altera(Aluno umAluno) throws AlunoNaoEncontradoException;
    void exclui(long id) throws AlunoNaoEncontradoException;
    Aluno recuperaUmAluno(long numero) throws AlunoNaoEncontradoException;
    List<Aluno> recuperaAlunos();
}