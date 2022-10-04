package model.entities;

/**
 * Esta é a classe Plano, tendo como atributo idPlano, operadora, nome, quantidadeDados, quantidadeDadosBonus, beneficios e valor.
 */

public class Plano {
    private int idPlano, quantidadeDados, quantidadeDadosBonus;
    private String operadora, nome, beneficios;
    private double valor;

    public Plano(int idPlano, String operadora, String nome, int quantidadeDados, int quantidadeDadosBonus, String beneficios, double valor) {
        this.idPlano = idPlano;
        this.operadora = operadora;
        this.nome = nome;
        this.quantidadeDados = quantidadeDados;
        this.quantidadeDadosBonus = quantidadeDadosBonus;
        this.beneficios = beneficios;
        this.valor = valor;
    }

    public Plano(String operadora, String nome, int quantidadeDados, int quantidadeDadosBonus, String beneficios, double valor) {
        this.operadora = operadora;
        this.nome = nome;
        this.quantidadeDados = quantidadeDados;
        this.quantidadeDadosBonus = quantidadeDadosBonus;
        this.beneficios = beneficios;
        this.valor = valor;
    }

    public int getQuantidadeDados() {
        return quantidadeDados;
    }

    public int getQuantidadeDadosBonus() {
        return quantidadeDadosBonus;
    }

    public String getOperadora() {
        return operadora;
    }

    public String getNome() {
        return nome;
    }

    public String getBeneficios() {
        return beneficios;
    }

    public double getValor() {
        return valor;
    }

    @Override
    public String toString() {
        return "\nID plano: " + idPlano +
                "\nOperadora: " + operadora +
                "\nNome: " + nome +
                "\nQuantidade de dados: " + quantidadeDados +
                "\nValor: " + valor +
                "\n- - - - - - - - - - - - - - - - - - - -";
    }

    public String toStringCompleto() {
        return "\nID plano: " + idPlano +
                "\nOperadora: " + operadora +
                "\nNome: " + nome +
                "\nQuantidade de dados: " + quantidadeDados +
                "\nQuantidade de dados bonus: " + quantidadeDadosBonus +
                "\nBenefícios: " + beneficios +
                "\nValor: " + valor +
                "\n- - - - - - - - - - - - - - - - - - - -";
    }
}