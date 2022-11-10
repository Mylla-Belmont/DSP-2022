package trabalho_02.example.trabalho_02.dao;

import org.springframework.stereotype.Repository;
import trabalho_02.example.trabalho_02.entity.Ator;
import org.springframework.data.jpa.repository.JpaRepository;

@Repository
public interface AtorDAO extends JpaRepository<Ator, Integer> {
    
    public Ator findById(int id);
}
