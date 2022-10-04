package model.service;

import model.dao.PlanoDao;
import model.entities.Plano;

import java.util.Collection;

/**
 * Esta é a classe PlanoService, responsável pelos serviços e por fazer a comunicação entre a classe PlanoDao e a classe PlanoController.
 */

public class PlanoService {
    public void cadastrarPlano(Plano plano) {
        try {
            PlanoDao planoDao = new PlanoDao();
            planoDao.cadastrarPlano(plano);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public Collection<Plano> listarTodosPlanos() {
        try {
        PlanoDao planoDao = new PlanoDao();
        return planoDao.listarTodosPlanos();
    } catch (Exception e) {
        throw new RuntimeException(e);
    }
    }

    public Collection<Plano> listarPlanosOperadora(String operadora) {
        try {
        PlanoDao planoDao = new PlanoDao();
        return planoDao.listarPlanosOperadora(operadora);
    } catch (Exception e) {
        throw new RuntimeException(e);
        }
    }

    public Plano listarPlanoId(int idPlano) {
        try {
        PlanoDao planoDao = new PlanoDao();
        return planoDao.listarPlanoId(idPlano);
        } catch (Exception e) {
        throw new RuntimeException(e);
        }
    }

    public void editarPlano() {
        try {
        PlanoDao planoDao = new PlanoDao();
        planoDao.editarPlano();
        } catch (Exception e) {
        throw new RuntimeException(e);
        }
    }

    public void excluirPlano(int idPlano) {
        try {
        PlanoDao planoDao = new PlanoDao();
        planoDao.excluirPlano(idPlano);
        } catch (Exception e) {
        throw new RuntimeException(e);
        }
    }
}