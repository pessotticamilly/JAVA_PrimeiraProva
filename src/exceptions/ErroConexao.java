package exceptions;

/**
 * Esta é a Exception que será lançada caso a conexão não possa ser estabelecida por algum motivo.
 */

public class ErroConexao extends Exception {

    public ErroConexao(String erro_na_conexão) {
    }
}