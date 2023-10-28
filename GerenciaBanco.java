package com.mycompany.gerenciabanco;

import java.util.Scanner;

public class GerenciaBanco {

    public static void main(String[] args) { 
       Scanner scanner = new Scanner(System.in);
        ContaBancaria conta = new ContaBancaria();

        System.out.println("Informe seus dados pessoais:");
        System.out.print("Nome: ");
        String nome = scanner.next();
        System.out.print("Sobrenome: ");
        String sobrenome = scanner.next();
        System.out.print("CPF: ");
        String cpf = scanner.next();
        conta.setDadosPessoais(nome, sobrenome, cpf);

        do {
            exibirMenu();
            int escolha = scanner.nextInt();

            switch (escolha) {
                case 1:
                    System.out.print("Informe o valor do depósito: ");
                    double valorDeposito = scanner.nextDouble();
                    conta.depositar(valorDeposito);
                    break;
                case 2:
                    System.out.print("Informe o valor do saque: ");
                    double valorSaque = scanner.nextDouble();
                    if (conta.sacar(valorSaque)) {
                        System.out.println("Saque realizado com sucesso!");
                    } else {
                        System.out.println("Saldo insuficiente para o saque.");
                    }
                    break;
                case 3:
                    System.out.println("Saldo atual: R$" + conta.getSaldo());
                    break;
                case 4:
                    System.out.println("Encerrando o uso da aplicação.");
                    break;
                default:
                    System.out.println("Opção inválida. Por favor, escolha uma opção válida.");
            }
        } while (conta.getOpcao() != 4);

        scanner.close();
    }

    public static void exibirMenu() {
        System.out.println("\nMenu:");
        System.out.println("1. Realizar Depósito");
        System.out.println("2. Realizar Saque");
        System.out.println("3. Consultar Saldo");
        System.out.println("4. Encerrar");
        System.out.print("Escolha uma opção: ");
    }
}

class ContaBancaria {
    private double saldo;
    private int opcao;
    private String nome;
    private String sobrenome;
    private String cpf;

    public ContaBancaria() {
        saldo = 0.0;
        opcao = 0;
        nome = "";
        sobrenome = "";
        cpf = "";
    }

    public void depositar(double valor) {
        saldo += valor;
    }

    public boolean sacar(double valor) {
        if (saldo >= valor) {
            saldo -= valor;
            return true;
        } else {
            return false;
        }
    }

    public double getSaldo() {
        return saldo;
    }

    public int getOpcao() {
        return opcao;
    }

    public void setOpcao(int opcao) {
        this.opcao = opcao;
    }

    public void setDadosPessoais(String nome, String sobrenome, String cpf) {
        this.nome = nome;
        this.sobrenome = sobrenome;
        this.cpf = cpf;
    }
}
