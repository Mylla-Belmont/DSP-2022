package lista_07.lista_07.dao;

import java.sql.ResultSet;
import java.sql.SQLException;

import lista_07.lista_07.entidade.Alunos;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.stereotype.Repository;

@Repository
@Primary
public class ClienteJDBCDAO {
    
    @Autowired
    private NamedParameterJdbcTemplate jdbcTemplate;

    public ClienteJDBCDAO() { }

    public void salvar(Alunos aluno) {
        String insert_sql = "insert into Alunos (id, cpf, matricula, nome, email, telefone)" + 
                            "values (:id, :cpf, :matricula, :nome, :email, :telefone)";
        String update_sql = "update Alunos set cpf = :cpf, matricula = :matricula, nome = :nome" + 
                            "email = :email, telefone = :telefone";
        MapSqlParameterSource params = new MapSqlParameterSource()
                        .addValue("id", aluno.getId())
                        .addValue("cpf", aluno.getCpf())
                        .addValue("matricula", aluno.getMatricula())
                        .addValue("nome", aluno.getNome())
                        .addValue("email", aluno.getEmail())
                        .addValue("telefone", aluno.getTelefone());
        if(aluno.getId() == 0) {
            jdbcTemplate.update(insert_sql, params);
        } else {
            params.addValue("id", aluno.getId());
			jdbcTemplate.update(update_sql, params);
        }
    }

    public void deletar(int id) {
        String delete_sql = "delete from Alunos where id = id";
        MapSqlParameterSource params = new MapSqlParameterSource()
                        .addValue(delete_sql, id);
        jdbcTemplate.update(delete_sql, params);
    }

    private Alunos map(ResultSet rs) throws SQLException {
        Alunos aluno = new Alunos();
        aluno.setId(rs.getInt("id"));
        aluno.setCpf(rs.getString("cpf"));
        aluno.setMatricula(rs.getString("matricula"));
        aluno.setNome(rs.getString("nome"));
        aluno.setEmail(rs.getString("email"));
        aluno.setTelefone(rs.getString("telefone"));
        return aluno;
    }

    public Alunos consultar(int id) {
        String find_sql = "select id, cpf, matricula, nome, email, telefone" +
                          "from Alunos where id = :id_";
        SqlParameterSource params = new MapSqlParameterSource()
                        .addValue("id_", id);
        return jdbcTemplate.queryForObject(find_sql, params, (rs, rowNum) -> map(rs));
    }
}

//Melhorar dps