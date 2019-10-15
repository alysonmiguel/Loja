/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package loja;

import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author Aluno
 */
public class Loja {

    ArrayList<Pessoa> lista = new ArrayList<>();
    Scanner entrada = new Scanner(System.in);

    public void menu() {
        int op;
        do {

            System.out.println("\n\tLoja "
                    + "\n1 - Cadastrar pessoas "
                    + "\n2 - Remover pessoa "
                    + "\n3 - Buscar pessoa "
                    + "\n4 - Adicionar Produtividade "
                    + "\n5 - Gerar Folha de Pagamento "
                    + "\n6 - Sair ");
            op = entrada.nextInt();

            entrada.nextLine(); // Limpa o buffer

            switch (op) {
                case 1:
                    cadastrar();
                    break;
                case 2:
                    remover();
                    break;
                case 3:
                    buscar();
                    break;
                case 4:
                    adicionarProdutividade();
                    break;
                case 5:
                    geraFolhaPagamento();
                    break;
                case 6:
                    System.out.println("Saindo...");
                    break;

                default:
                    System.out.println("Opção inválida!");
                    break;
            }
        } while (op != 6);
    }

    private void cadastrar() {
        int op;
        int numeroMatricula = 0;
        double salario = 0;
        String nome = null, cpf = null;
        Pessoa p = null;
        System.out.println("\n\tCadastrar "
                + "\n1-Cliente "
                + "\n2-Administrador"
                + "\n3-Vendedor "
                + "\n4-Voltar");
        op = entrada.nextInt();

        if (op > 0 && op < 4) {
            System.out.print("Insira os dados do funcionario\n"
                    + "Nome: ");
            nome = entrada.next();
            System.out.print("CPF: ");
            cpf = entrada.next();
            if (op == 2 || op == 3) {
                System.out.print("Matrícula: ");
                numeroMatricula = entrada.nextInt();
                System.out.print("Salário: ");
                salario = entrada.nextDouble();
            }
        }

        switch (op) {
            case 1:
                System.out.println("Insira o código do cliente: ");
                lista.add(new Cliente(entrada.next(), nome, cpf));
                break;
            case 2:
                lista.add(new Administrador(numeroMatricula, salario, nome, cpf));
                break;
            case 3:
                lista.add(new Vendedor(numeroMatricula, salario, nome, cpf));
                break;
            case 4:
                System.out.println("Saindo...");
                break;
            default:
                System.out.println("Opção inválida!");
                break;
        }
    }

    private void remover() {
        System.out.println("Por favor informe um CPF");

        Pessoa p = buscar(entrada.nextLine());

        if (p != null) {
            for (int i = 0; i < lista.size(); i++) {
                if (lista.get(i).getCpf().equals(p.getCpf())) {
                    System.out.println(p.getNome() + " foi removido.");
                    lista.remove(i);
                }
            }
        }

    }

    private void buscar() {
        System.out.println("Por favor informe um CPF");
        Pessoa p = buscar(entrada.nextLine());

        if (!lista.isEmpty()) {
            if (p != null) {
                System.out.println(p.toString());
            }
        }

    }

    private Pessoa buscar(String cpf) {

        for (Pessoa p : lista) {
            if (p.getCpf().equals(cpf)) {
                if (p instanceof Funcionario) {
                    if (p instanceof Administrador) {
                        return ((Administrador) p);
                    } else {
                        return ((Vendedor) p);
                    }
                } else {
                    return ((Cliente) p);
                }
            }
        }
        System.out.println("CPF não encontrado.");
        return null;
    }

    private void listar() {
        for (Pessoa p : lista) {
            if (p instanceof Funcionario) {
                if (p instanceof Administrador) {
                    System.out.println(((Administrador) p).toString());
                } else {
                    System.out.println(((Vendedor) p).toString());
                }
            } else {
                System.out.println(((Cliente) p).toString());
            }
        }
    }

    private void adicionarProdutividade() {
         System.out.println("Por favor informe um CPF");
        Pessoa p = buscar(entrada.nextLine());

        if (p != null) {
            if (p instanceof Funcionario) {
                if (p instanceof Administrador) {
                    System.out.println("\nInforme a quantidade de horas extra do funcionário: ");
                    ((Administrador) p).setHoras(entrada.nextDouble());
                } else {
                    System.out.println("\nInforme o total de vendas do funcionário: ");
                    ((Vendedor) p).setVendas(entrada.nextDouble());
                }
            }
        }
    }

    private void geraFolhaPagamento() {
        for (Pessoa p : lista) {
            if (p instanceof Administrador) {
                ((Administrador) p).calcularPagamento();
                System.out.println(((Administrador) p).toString());
            } else if (p instanceof Vendedor) {
                ((Vendedor) p).calcularPagamento();
                System.out.println(((Vendedor) p).toString());
            }
        }
    }
}
