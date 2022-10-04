package view;

import controller.PlanoController;
import model.entities.Plano;

import java.util.Scanner;

/**
 * Esta é a classe executável, como o próprio nome diz, ela é responsável por executar o programa.
 *
 * @author Camilly Pessotti
 * @version 1.0
 */

public class Main {
    static Scanner sc = new Scanner(System.in);
    static PlanoController planoController = new PlanoController();

    public static void main(String[] args) {
        menu();
    }

    private static void menu() {
        System.out.print("""
                ---- MENU ----
                1 - Cadastrar plano
                2 - Listar todos os planos
                3 - Listar planos de uma operadora
                4 - Listar plano por ID
                5 - Editar plano
                6 - Excluir plano
                7 - Encerrar
                >\s""");
        int opcao = sc.nextInt();

        switch (opcao) {
            case 1 -> cadastrarPlano();
            case 2 -> listarTodosPlanos();
            case 3 -> listarPlanosOperadora();
            case 4 -> listarPlanoId();
            case 5 -> editarPlano();
            case 6 -> excluirPlano();
            case 7 -> {
                System.out.print("\nEncerrando...");
                System.exit(0);
            }
            default -> {
                System.out.print("\nOpção inválida! Tente novamente:\n");
                menu();
            }
        }
    }

    private static Plano coletaDados() {
        System.out.print("\nOperadora\n> ");
        String operadora = sc.next();

        System.out.print("Nome\n> ");
        String nome = sc.next();

        System.out.print("Quantidade de dados\n> ");
        int quantidadeDados = sc.nextInt();

        System.out.print("Quantidade de dados bônus\n> ");
        int quantidadeDadosBonus = sc.nextInt();

        System.out.print("Benefícios\n> ");
        String beneficios = sc.next();

        System.out.print("Valor\n> ");
        double valor = sc.nextDouble();

        return new Plano(operadora, nome, quantidadeDados, quantidadeDadosBonus, beneficios, valor);
    }

    private static void cadastrarPlano() {
        Plano plano = coletaDados();
        planoController.cadastrarPlano(plano);

        System.out.print("\nPlano cadastrado com sucesso!\n\n");
        menu();
    }

    private static void listarTodosPlanos() {
        System.out.println(planoController.listarTodosPlanos().toString());
        System.out.println();
        menu();
    }

    private static void listarPlanosOperadora() {
        System.out.print("\nOperadora dos planos a serem listados\n> ");
        String operadora = sc.next();

        System.out.println(planoController.listarPlanosOperadora(operadora).toString());
        menu();
    }

    private static void listarPlanoId() {
        System.out.print("\nID do plano a ser listado\n> ");
        int idPlano = sc.nextInt();

        System.out.println(planoController.listarPlanoId(idPlano).toStringCompleto());
        menu();
    }

    private static void editarPlano() {
        System.out.print("\nID do plano a ser editado\n> ");
        int idPlano = sc.nextInt();

        Plano novoPlano = coletaDados();

        planoController.editarPlano(idPlano, novoPlano);

        System.out.print("\nPlano editado com sucesso!\n\n");
        menu();
    }

    private static void excluirPlano() {
        System.out.print("\nID do plano a ser excluído\n> ");
        int idPlano = sc.nextInt();

        planoController.excluirPlano(idPlano);
        System.out.print("\nPlano excluído com sucesso!\n\n");
        menu();
    }
}