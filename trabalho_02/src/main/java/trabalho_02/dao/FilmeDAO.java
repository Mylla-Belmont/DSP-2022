package trabalho_02.dao;

import trabalho_02.entity.Filme;
import java.util.List;

public interface FilmeDAO {
    public void findById(int id); 
    public List<Filme> listByActor(String ator);
    public List<Filme> listByYear(int ano);
    public List<Filme> listByString(String stg);
    public List<Filme> showAllMovie();
}
