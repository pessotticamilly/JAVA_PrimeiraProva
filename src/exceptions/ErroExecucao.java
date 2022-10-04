package exceptions;

/**
 * Esta é a Exception que será lançada quando a execução de um comando SQL tiver alguma falha.
 */

public class ErroExecucao extends Exception{
    public ErroExecucao(String mensagem) {
        System.out.print(mensagem);
    }
}