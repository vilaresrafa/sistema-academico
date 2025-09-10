package com.projetodw.dao.impl;

import com.projetodw.dao.AlunoDAO;
import com.projetodw.excecao.AlunoNaoEncontradoException;
import com.projetodw.modelo.Aluno;
import com.projetodw.util.FabricaDeEntityManager;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.LockModeType;
import java.util.List;

public class JPAAlunoDAO implements AlunoDAO
{
    public long inclui(Aluno umAluno)
    {
        EntityManager em = null;
        EntityTransaction tx = null;

        try
        {
            em = FabricaDeEntityManager.criarEntityManager();
            tx = em.getTransaction();

            tx.begin();
            em.persist(umAluno);

            System.out.println("nome = " + umAluno.getNome());

            tx.commit();

            return umAluno.getMatricula();
        }
        catch(RuntimeException e)
        {	if (tx != null)
        {
            tx.rollback();
        }
            throw e;
        }
        finally
        {
            em.close();
        }
    }

    public Aluno recuperaUmAluno(long matricula) throws AlunoNaoEncontradoException
    {
        EntityManager em = null;

        try
        {
            em = FabricaDeEntityManager.criarEntityManager();
            Aluno umAluno = em.find(Aluno.class, matricula);

            if(umAluno == null){
                throw new AlunoNaoEncontradoException("Aluno nao encontrado");
            }
            return umAluno;
        }
        finally {
            em.close();
        }
    }

    public void altera(Aluno umAluno) throws  AlunoNaoEncontradoException
    {
        EntityManager em = null;
        EntityTransaction tx = null;
        Aluno aluno = null;
        try
        {
            em = FabricaDeEntityManager.criarEntityManager();
            tx = em.getTransaction();
            tx.begin();

            aluno = em.find(Aluno.class, umAluno.getNome(), LockModeType.PESSIMISTIC_WRITE);
            if(aluno == null){
                tx.rollback();
                throw new AlunoNaoEncontradoException(
                        "Aluno com nome = " + umAluno.getNome() + " nao encontrado");
            }
            em.merge(umAluno);

            tx.commit();
        }
        catch (RuntimeException e){
            if (tx != null)
            {
                tx.rollback();
            } throw e;
        }
        finally {
            em.close();
        }
    }

    public void exclui(long matricula) throws AlunoNaoEncontradoException
    {
        EntityManager em = null;
        EntityTransaction tx = null;

        try
        {
            em = FabricaDeEntityManager.criarEntityManager();
            tx = em.getTransaction();
            tx.begin();

            Aluno aluno = em.find(Aluno.class, matricula);

            if(aluno == null)
            {
                tx.rollback();
                throw new AlunoNaoEncontradoException("Aluno nao encontrado");
            }

            em.remove(aluno);
            tx.commit();
        }
        catch(RuntimeException e)
        {
            if (tx != null)
            {   tx.rollback();
            }
            throw e;
        }
        finally
        {   em.close();
        }
    }

    public List<Aluno> recuperaAlunos()
    {
        EntityManager em = null;

        try
        {
            em = FabricaDeEntityManager.criarEntityManager();

            List alunos = em
                    .createQuery("select a from Aluno a order by a.id")
                    .getResultList();

            return alunos;
        }
        finally {
            em.close();
        }
    }
}