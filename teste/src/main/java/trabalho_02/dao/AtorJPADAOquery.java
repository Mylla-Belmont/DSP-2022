package trabalho_02.dao;

import java.util.List;
import javax.persistence.EntityManager;
import trabalho_02.entity.Ator;
import trabalho_02.util.JPAUtil;

public class AtorJPADAOquery implements AtorDAO {
    // JPQL
    public void findById(int id) {
        EntityManager em = JPAUtil.getEntityManager();
        System.out.println("###############################");
        // List<Ator> moviesById = em.createQuery("from Ator", Ator.class)
        //             .setParameter("id", id + "%")
        //             .getResultList();
        // for (Ator ator : moviesById) {
        //     System.out.println("Id: " + ator.getId());
        //     System.out.println("Nome: " + ator.getNome());
        //     System.out.println("Ano de Nascimento: " + ator.getDataNascimento());
        //     System.out.println("Filmes: " + ator.getfilme_ator());
        // }
        // JPAUtil.closeEntityManager();
    }

    // Named Query
    public List<Ator> listByMovies(String filme) {
        EntityManager em = JPAUtil.getEntityManager();
        List<Ator> listActorsByMovies = em.createNamedQuery("Ator.findMoviesByActor", Ator.class)
                    .setParameter("filme", filme + "%")
                    .getResultList();
        JPAUtil.closeEntityManager();
        return listActorsByMovies;
    }

    // Named Query
    public List<Ator> listNameByYear(int ano) {
        EntityManager em = JPAUtil.getEntityManager();
        List<Ator> listAtorsByYear = em.createNamedQuery("Ator.findActorsByYear", Ator.class)
                    .setParameter("ano", ano + "%")
                    .getResultList();
        JPAUtil.closeEntityManager();
        return listAtorsByYear;
    }
}
