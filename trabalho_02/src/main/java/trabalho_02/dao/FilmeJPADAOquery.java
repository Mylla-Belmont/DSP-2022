package trabalho_02.dao;

import java.util.List;
import trabalho_02.entity.Filme;
import trabalho_02.util.JPAUtil;
import javax.persistence.EntityManager;

public class FilmeJPADAOquery implements FilmeDAO {

    // JPQL
    public Object findById(int id) {
        EntityManager em = JPAUtil.getEntityManager();
        List<Filme> moviesById = em.createQuery("from Filme", Filme.class)
                    .setParameter("id", id + "%")
                    .getResultList();
        for (Filme filme : moviesById) {
            System.out.println("Id: " + filme.getId());
            System.out.println("Id: " + filme.getId());
        }
        return null;
    }

    public List<Filme> listByActor(String ator) {
        // EntityManager em = JPAUtil.getEntityManager();
        // List<Filme> moviesByActor = em.createQuery("from Filme", Filme.class).getResultList();
        return null;
    }

    public List<Filme> listByYear(int ano) {
        
        return null;
    }

    public List<Filme> listByString(String stg) {
        
        return null;
    }

    public List<Filme> showAllMovie() {
        
        return null;
    }
}
