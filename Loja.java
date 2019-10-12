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

            System.out.println("\n\n\tLoja "
                    + "1 - Cadastrar pessoas "
                    + "2 - Remover pessoa "
                    + "3 - Buscar pessoa "
                    + "4 - Adicionar Produtividade "
                    + "5 - Gerar Folha de Pagamento "
                    + "6 - Sair ");
            op = entrada.nextInt();

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
                    break;
                case 5:
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
        do {
            System.out.println("\n\tCadastrar "
                    + "1-Cliente "
                    + "2-Administrativo"
                    + "3-Vendedor "
                    + "4-Voltar");
            op = entrada.nextInt();

            if (op > 0 && op < 6) {
                System.out.print("Insira os dados do funcionario"
                        + "Nome: ");
                nome = entrada.nextLine();
                System.out.print("CPF: ");
                cpf = entrada.nextLine();
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
        } while (op != 4);
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

    }

    private void adicionarProdutivadade() {

    }

    private void gerarFolhaPagamento() {

    }

}
