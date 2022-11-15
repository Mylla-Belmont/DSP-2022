package trabalho_02.example.trabalho_02.dao;

import java.util.List;
import org.springframework.stereotype.Repository;
import trabalho_02.example.trabalho_02.entity.Filme;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.JpaRepository;

@Repository
public interface FilmeDAO extends JpaRepository<Filme, Integer> {

    public Filme findById(int id);

    @Query(name="Filme.findByYear")
    public List<Filme> listByYear(String anoLancamento);
    
    @Query("select f from Filme f where f.titulo like :stringTitulo%")
    public List<Filme> listByString(String stringTitulo);
}
