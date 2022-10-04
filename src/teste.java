import controller.PlanoController;
import model.entities.Plano;

import java.util.Scanner;

public class teste {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        PlanoController planoController = new PlanoController();

        System.out.println("Operadora");
        String operadora = sc.next();

        System.out.println("Nome");
        String nome = sc.next();

        System.out.println("Quantidade de dados");
        int quantidadeDados = sc.nextInt();

        System.out.println("Quantidade de dados bônus");
        int quantidadeDadosBonus = sc.nextInt();

        System.out.println("Benefícios");
        String beneficios = sc.next();

        System.out.println("Valor");
        double valor = sc.nextDouble();

        Plano plano = new Plano(operadora, nome, quantidadeDados, quantidadeDadosBonus, beneficios, valor);
        planoController.cadastrarPlano(plano);
    }
}
