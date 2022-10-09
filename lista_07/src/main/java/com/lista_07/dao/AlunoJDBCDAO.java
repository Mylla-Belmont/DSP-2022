package com.lista_07.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.lista_07.entidade.Aluno;

public class AlunoJDBCDAO implements AlunoDAO {

    public AlunoJDBCDAO() { }

    public void salvar(Aluno aluno) {
        Connection connection = null;
        try {
            connection = ConnectionFactory.getConnection();
            String insert_sql = "insert into Alunos (cpf, matricula, nome, email, telefone)" + 
                            "values (?, ?, ?, ?, ?)";
            String update_sql = "update Alunos set cpf = ?, matricula = ?, nome = ?" + 
                                "email = ?, telefone = ? where id = ?";
            PreparedStatement pst;
            if (aluno.getId() == 0) {
                pst = connection.prepareStatement(insert_sql);
            } else {
                pst = connection.prepareStatement(update_sql);
                pst.setInt(6, aluno.getId());
            }
            pst.setString(1, aluno.getCpf());
            pst.setString(2, aluno.getMatricula());
            pst.setString(3, aluno.getNome());
            pst.setString(4, aluno.getEmail());
            pst.setString(5, aluno.getTelefone());
            pst.executeUpdate();

        } catch (SQLException e) {
            throw new DAOException("Ocorreu um problema durante a operação.", e);
        } finally {
            try {
                if (connection != null)
                    connection.close();
            } catch (SQLException e) {
                throw new DAOException("Não foi possivel fechar a conexão.", e);
            }
        }
    }

    public void deletar(int id) {
        Connection connection = null;
        try {
            connection = ConnectionFactory.getConnection();
            String delete_sql = "delete from Alunos where id = ?";
            PreparedStatement pst = connection.prepareStatement(delete_sql);
            pst.setInt(1, id);
			pst.executeUpdate();

        } catch (SQLException e) {
            throw new DAOException("Ocorreu um problema durante a operação.", e);
        } finally {
            try {
                if (connection != null)
                    connection.close();
            } catch (SQLException e) {
                throw new DAOException("Não foi possivel fechar a conexão.", e);
            }
        }
    }

    private Aluno map(ResultSet result) throws SQLException {
        Aluno aluno = new Aluno();
        aluno.setId(result.getInt("id"));
        aluno.setCpf(result.getString("cpf"));
        aluno.setMatricula(result.getString("matricula"));
        aluno.setNome(result.getString("nome"));
        aluno.setEmail(result.getString("email"));
        aluno.setTelefone(result.getString("telefone"));
        return aluno;
    }

    public Aluno consultar(int id) {
        Connection connection = null;
        Aluno aluno = null;
        try {
            connection = ConnectionFactory.getConnection();
            String find_sql = "select id, cpf, matricula, nome, email, telefone" +
                              "from Alunos where id = ?";
            PreparedStatement pst = connection.prepareStatement(find_sql);
            pst.setInt(1, id);
            ResultSet result = pst.executeQuery();
            if (result.next()) {
				aluno = map(result);
			}
        } catch (SQLException e) {
            throw new DAOException("Ocorreu um problema durante a operação.", e);
        } finally {
            try {
                if (connection != null)
                    connection.close();
            } catch (SQLException e) {
                throw new DAOException("Não foi possivel fechar a conexão.", e);
            }
        }
        return aluno;
    }    
}
