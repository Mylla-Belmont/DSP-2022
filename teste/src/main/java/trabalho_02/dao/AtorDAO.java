package trabalho_02.dao;

import trabalho_02.entity.Ator;
import java.util.List;

public interface AtorDAO {
    public void findById (int id);
    public List<Ator> listByMovies (String filme);
    public List<Ator> listNameByYear (int ano);
}
