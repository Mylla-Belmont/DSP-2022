package trabalho_02.example.trabalho_02.dao;

import org.springframework.stereotype.Repository;
import trabalho_02.example.trabalho_02.entity.Filme;
import org.springframework.data.jpa.repository.JpaRepository;

@Repository
public interface FilmeDAO extends JpaRepository<Filme, Integer> {
    
    public Filme findById(int id);
}
