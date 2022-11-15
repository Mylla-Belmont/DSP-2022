package trabalho_02.example.trabalho_02.dao;

import java.util.List;
import org.springframework.stereotype.Repository;
import trabalho_02.example.trabalho_02.entity.Ator;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.JpaRepository;

@Repository
public interface AtorDAO extends JpaRepository<Ator, Integer> {
    
    public Ator findById(int id);

    @Query("select a from Ator a where a.nome = :nome")
    public Ator findByName(String nome);

    @Query(value="select a from Ator a where a.anoNascimento like :anoNascimento%")
    public List<Ator> findByYear(String anoNascimento);
}
