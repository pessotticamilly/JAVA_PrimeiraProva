package model.dao;

import exceptions.ErroConexao;
import exceptions.ErroExecucao;
import exceptions.ErroTratamento;
import model.entities.Plano;
import model.factory.ConexaoFactory;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collection;

/**
 * Esta é a classe PlanoDao, que faz as alterações diretamente nossa entidade Plano. Tento um crud básico de cadastro, listagem, edição e exclusão.
 */

public class PlanoDao {
    private final Connection connection;
    Collection<Plano> listaTodosPlanos = new ArrayList<>();
    Collection<Plano> listaPlanosOperadora = new ArrayList<>();

    public PlanoDao() throws ErroConexao {
        this.connection = new ConexaoFactory().conexaoBD();
    }

    public void cadastrarPlano(Plano plano) throws ErroExecucao, SQLException {
        String sql = "INSERT INTO plano (operadora, nome, quantidadeDados, quantidadeDadosBonus, beneficios, valor) VALUES (?, ?, ?, ?, ?, ?);";
        String operadora = plano.getOperadora();

        try (PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
            preparedStatement.setInt(1, (operadora.equals("Claro")) ? 1 : (operadora.equals("Oi")) ? 2 : (operadora.equals("Tim")) ? 3 : 4);
            preparedStatement.setString(2, plano.getNome());
            preparedStatement.setInt(3, plano.getQuantidadeDados());
            preparedStatement.setInt(4, plano.getQuantidadeDadosBonus());
            preparedStatement.setString(5, plano.getBeneficios());
            preparedStatement.setDouble(6, plano.getValor());

            try {
                preparedStatement.execute();
            } catch (Exception e) {
                throw new ErroExecucao("\nErro na execução do comando SQL\n\n");
            }
        }
    }

    public Collection<Plano> listarTodosPlanos() throws ErroExecucao, SQLException {
        String sql = "SELECT * FROM plano ORDER BY operadora;";

        try (PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
            try (ResultSet resultSet = preparedStatement.executeQuery()) {
                while (resultSet.next()) {
                    listaTodosPlanos.add(extrairObjeto(resultSet));
                }

                return listaTodosPlanos;
            } catch (Exception e) {
                throw new ErroExecucao("\nErro na execução do comando SQL\n\n");
            }
        }
    }

    public Collection<Plano> listarPlanosOperadora(String operadora) throws ErroExecucao, SQLException {
        String sql = "SELECT * FROM plano WHERE operadora = ?;";

        try (PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
            preparedStatement.setString(1, operadora);
            try (ResultSet resultSet = preparedStatement.executeQuery()) {
                while (resultSet.next()) {
                    listaPlanosOperadora.add(extrairObjeto(resultSet));
                }

                return listaPlanosOperadora;
            } catch (Exception e) {
                throw new ErroExecucao("\nErro na execução do comando SQL\n\n");
            }
        }
    }

    public Plano listarPlanoId(int idPlano) throws ErroExecucao, SQLException {
        Plano plano = null;
        String sql = "SELECT * FROM plano WHERE idPlano = ?;";

        try (PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
            preparedStatement.setInt(1, idPlano);

            try {
                ResultSet resultSet = preparedStatement.executeQuery();

                if (resultSet.next()) {
                    return extrairObjeto(resultSet);
                }

                return plano;
            } catch (Exception e) {
                throw new ErroExecucao("\nErro na execução do comando SQL\n\n");
            }
        }
    }

    public void editarPlano(int idPlano, Plano novoPlano) throws ErroExecucao, SQLException {
        String sql = "UPDATE plano SET operadora = ?, nome = ?, quantidadeDados = ?, quantidadeDadosBonus = ?, beneficios = ?, valor = ? WHERE idPlano = ?";

        try (PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
            preparedStatement.setString(1, novoPlano.getOperadora());
            preparedStatement.setString(2, novoPlano.getNome());
            preparedStatement.setInt(3, novoPlano.getQuantidadeDados());
            preparedStatement.setInt(4, novoPlano.getQuantidadeDadosBonus());
            preparedStatement.setString(5, novoPlano.getBeneficios());
            preparedStatement.setDouble(6, novoPlano.getValor());
            preparedStatement.setInt(7, idPlano);

            try {
                preparedStatement.execute();
            } catch (Exception e) {
                throw new ErroExecucao("\nErro na execução do comando SQL\n\n");
            }
        }
    }

    public void excluirPlano(int idPlano) throws ErroExecucao, SQLException {
        String sql = "DELETE FROM plano WHERE idPlano = ?;";

        try (PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
            preparedStatement.setInt(1, idPlano);

            try {
                preparedStatement.execute();
            } catch (Exception e) {
                throw new ErroExecucao("\nErro na execução do comando SQL\n\n");
            }
        }
    }

    private Plano extrairObjeto(ResultSet resultSet) throws ErroTratamento {
        try {
            return new Plano(
                    resultSet.getInt("idPlano"),
                    resultSet.getString("operadora"),
                    resultSet.getString("nome"),
                    resultSet.getInt("quantidadeDados"),
                    resultSet.getInt("quantidadeDadosBonus"),
                    resultSet.getString("beneficios"),
                    resultSet.getDouble("valor")
            );
        } catch (Exception e) {
            throw new ErroTratamento("\nErro ao extrair objeto\n\n");
        }
    }
}