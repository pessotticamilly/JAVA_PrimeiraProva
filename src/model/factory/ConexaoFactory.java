package model.factory;

import exceptions.ErroConexao;

import java.sql.Connection;
import java.sql.DriverManager;

/**
 * Esta é classe ConexaoFactory, responsável por fazer a conexão com o banco de dados.
 */

public class ConexaoFactory {
    public Connection conexaoBD() {
        String password = "root";
        String url = "jdbc:mysql://localhost:3306/java_primeiraprova";
        String username = "root";

        try {
            return DriverManager.getConnection(url, username, password);
        } catch(Exception e) {
            throw new ErroConexao("Erro na conexão");
        }
    }
}