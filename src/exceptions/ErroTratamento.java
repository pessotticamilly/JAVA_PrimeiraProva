package exceptions;

/**
 * Esta é a Exception que será lançada caso o tratamento do resultado da execução da Query tiver alguma falha.
 */

public class ErroTratamento extends Exception {
    public ErroTratamento(String mensagem) {
        super(mensagem);
    }
}