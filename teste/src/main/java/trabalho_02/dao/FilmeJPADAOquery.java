package trabalho_02.dao;

import java.util.List;
import trabalho_02.entity.Filme;
import trabalho_02.util.JPAUtil;
import javax.persistence.EntityManager;
import javax.persistence.criteria.*;

public class FilmeJPADAOquery implements FilmeDAO {
    // JPQL
    public void findById(int id) {
        EntityManager em = JPAUtil.getEntityManager();
        List<Filme> moviesById = em.createQuery("from Filme", Filme.class)
                    .setParameter("id", id + "%")
                    .getResultList();
        for (Filme filme : moviesById) {
            System.out.println("Id: " + filme.getId());
            System.out.println("Titulo: " + filme.getTitulo());
            System.out.println("Ano de Lançamento: " + filme.getAnoLancamento());
        }
        JPAUtil.closeEntityManager();
    }

    // Named Query
    public List<Filme> listByActor(String ator) {
        EntityManager em = JPAUtil.getEntityManager();
        List<Filme> moviesByActor = em.createNamedQuery("Filme.findById", Filme.class)
                    .setParameter("ator", ator + "%")
                    .getResultList();
        JPAUtil.closeEntityManager();
        return moviesByActor;
    }

    // Native Query
    public Object listByYear(int ano) {
        EntityManager em = JPAUtil.getEntityManager();
        Object filme = em.createNativeQuery("select * from Filmes where ano like :ano", Filme.class)
                         .getSingleResult();
        JPAUtil.closeEntityManager();
        return filme;
    }

    // Named Query
    public List<Filme> listByString(String stg) {
        EntityManager em = JPAUtil.getEntityManager();
        List<Filme> moviesByString = em.createNamedQuery("Filme.findByString", Filme.class)
                    .setParameter("stg", stg + "%")
                    .getResultList();
        return moviesByString;
    }

    // Criteria Query
    public List<Filme> showAllMovie() {
        EntityManager em = JPAUtil.getEntityManager();
        CriteriaBuilder cb = em.getCriteriaBuilder();
        CriteriaQuery<Filme> cq = cb.createQuery(Filme.class);
        cq.from(Filme.class);
        List<Filme> allMovies = em.createQuery(cq).getResultList();
        JPAUtil.closeEntityManager();
        return allMovies;
    }
}
