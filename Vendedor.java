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
public class Vendedor extends Funcionario{
    
    private double vendas;

    public Vendedor(int matricula, double salario, String nome, String cpf) {
        super(matricula, salario, nome, cpf);
    }

    public double getVendas() {
        return vendas;
    }

    public void setVendas(double vendas) {
        this.vendas = vendas * 0.1;
    }

    @Override
    public String toString() {
        return "Função: Vendedor \n" + super.toString();
    }

     @Override
     public double calcularPagamento(){
         setSalario(getSalario() + vendas);
        return getSalario();
    }  


 
}
