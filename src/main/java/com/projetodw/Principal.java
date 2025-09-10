package com.projetodw;

import com.projetodw.excecao.AlunoNaoEncontradoException;
import com.projetodw.modelo.Aluno;
import com.projetodw.dao.AlunoDAO;
import com.projetodw.util.FabricaDeDAOs;
import corejava.Console;

import java.util.List;

public class Principal
{	public static void main(String[] args)
    {
        String nome;
        String email;
        Aluno umAluno;

        AlunoDAO alunoDAO = FabricaDeDAOs.getDAO(AlunoDAO.class);

        boolean continua = true;
        while (continua)
        {
            System.out.println('\n' + "O que você deseja fazer?");
            System.out.println('\n' + "1. Cadastrar um aluno");
            System.out.println("2. Alterar um aluno");
            System.out.println("3. Remover um aluno");
            System.out.println("4. Listar todos os alunos");
            System.out.println("5. Sair");

            int opcao = Console.readInt('\n' +
                    "Digite um número entre 1 e 5:");

            switch(opcao) {
                case 1: {
                    nome = Console.readLine('\n' + "Informe o nome do Aluno: ");
                    email = Console.readLine('\n' + "Informe o email do Aluno: ");

                    umAluno = new Aluno(nome, email);

                    alunoDAO.inclui(umAluno);

                    System.out.println('\n' + "Aluno " + umAluno.getNome() + " cadastrado com sucesso!");

                    break;
                }

                case 2: {
                    int resposta = Console.readInt('\n' +
                            "Digite o nome do aluno que você deseja alterar: ");

                    try {
                        umAluno = alunoDAO.recuperaUmAluno(resposta);
                    } catch (AlunoNaoEncontradoException e) {
                        System.out.println('\n' + e.getMessage());
                        break;
                    }

                    System.out.println('\n' +
                            "Nome = " + umAluno.getNome() +
                            "    Email = " + umAluno.getEmail());

                    System.out.println('\n' + "O que você deseja alterar?");
                    System.out.println('\n' + "1. Nome");
                    System.out.println("2. Email");

                    int opcaoAlteracao = Console.readInt('\n' +
                            "Digite um número de 1 a 2:");

                    switch (opcaoAlteracao) {
                        case 1:
                            String novoNome = Console.
                                    readLine("Digite o novo nome: ");

                            umAluno.setNome(novoNome);

                            try {
                                alunoDAO.altera(umAluno);

                                System.out.println('\n' +
                                        "Alteração de nome efetuada com sucesso!");
                            } catch (AlunoNaoEncontradoException e) {
                                System.out.println('\n' + e.getMessage());
                            }

                            break;

                        case 2:
                            String novoEmail = Console.
                                    readLine("Digite o novo email: ");

                            umAluno.setEmail(novoEmail);

                            try {
                                alunoDAO.altera(umAluno);

                                System.out.println('\n' +
                                        "Alteração de email efetuada " +
                                        "com sucesso!");
                            } catch (AlunoNaoEncontradoException e) {
                                System.out.println('\n' + e.getMessage());
                            }

                            break;

                        default:
                            System.out.println('\n' + "Opção inválida!");
                    }

                    break;
                }

                case 3: {
                    int resposta = Console.readInt('\n' +
                            "Digite o número do aluno que você deseja remover: ");

                    try {
                        umAluno = alunoDAO.recuperaUmAluno(resposta);
                    } catch (AlunoNaoEncontradoException e) {
                        System.out.println('\n' + e.getMessage());
                        break;
                    }

                    System.out.println('\n' +
                            "Matricula = " + umAluno.getMatricula() +
                            "    Nome = " + umAluno.getNome() +
                            "    Email = " + umAluno.getEmail());

                    String resp = Console.readLine('\n' +
                            "Confirma a remoção do aluno?");

                    if (resp.equals("s")) {
                        try {
                            alunoDAO.exclui(umAluno.getMatricula());
                            System.out.println('\n' +
                                    "Aluno removido com sucesso!");
                        } catch (AlunoNaoEncontradoException e) {
                            System.out.println('\n' + e.getMessage());
                        }
                    } else {
                        System.out.println('\n' + "Aluno não removido.");
                    }

                    break;
                }

                case 4: {
                    List<Aluno> alunos = alunoDAO.recuperaAlunos();

                    for (Aluno aluno : alunos) {
                        System.out.println('\n' +
                                "Nome = " + aluno.getNome() +
                                "  Email = " + aluno.getEmail());
                    }

                    break;
                }

                case 5: {
                    continua = false;
                    break;
                }

                default:
                    System.out.println('\n' + "Opção inválida!");
            }
        }
    }
}
