package model.service;

import model.dao.PlanoDao;
import model.entities.Plano;

import java.util.Collection;

/**
 * Esta é a classe PlanoService, responsável pelos serviços e por fazer a comunicação entre a classe PlanoDao e a classe PlanoController.
 */

public class PlanoService {
    static PlanoDao planoDao = new PlanoDao();

    public void cadastrarPlano(Plano plano) {
        planoDao.cadastrarPlano(plano);
    }

    public Collection<Plano> listarTodosPlanos() {
        return planoDao.listarTodosPlanos();
    }

    public Collection<Plano> listarPlanosOperadora(String operadora) {
        return planoDao.listarPlanosOperadora(operadora);
    }

    public Plano listarPlanoId(int idPlano) {
        return planoDao.listarPlanoId(idPlano);
    }

    public void editarPlano() {
        planoDao.editarPlano();
    }

    public void excluirPlano(int idPlano) {
        planoDao.excluirPlano(idPlano);
    }
}