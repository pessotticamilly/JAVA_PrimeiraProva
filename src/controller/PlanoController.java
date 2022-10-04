package controller;

import model.entities.Plano;
import model.service.PlanoService;

import java.util.Collection;

/**
 * Esta é a classe PlanoController, responsável pelas requisições e fazer a comunicação entre a classe PlanoService e a classe Main (que é a nossa View).
 */

public class PlanoController {
    static PlanoService planoService = new PlanoService();

    public void cadastrarPlano(Plano plano) {
        planoService.cadastrarPlano(plano);
    }

    public Collection<Plano> listarTodosPlanos() {
        return planoService.listarTodosPlanos();
    }

    public Collection<Plano> listarPlanosOperadora(String operadora) {
        return planoService.listarPlanosOperadora(operadora);
    }

    public Plano listarPlanoId(int idPlano) {
        return planoService.listarPlanoId(idPlano);
    }

    public void editarPlano(int idPlano, Plano novoPlano) {
        planoService.editarPlano(idPlano, novoPlano);
    }

    public void excluirPlano(int idPlano) {
        planoService.excluirPlano(idPlano);
    }
}