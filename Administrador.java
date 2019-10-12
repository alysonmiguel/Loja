/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package loja;

/**
 *
 * @author Aluno
 */
public class Administrador extends Funcionario {

    private double horas;

    public Administrador(int matricula, double salario, String nome, String cpf) {
        super(matricula, salario, nome, cpf);
    }

    public double getHoras() {
        return horas;
    }

    public void setHoras(double horas) {
        this.horas = horas;
    }

    @Override
    public String toString() {
        return "Administrador{" + "horas=" + horas + '}';
    }

    
    @Override
    public double calcularPagamento() {
         setSalario(getSalario() + horas * getSalario());
        return getSalario();
    }

}
