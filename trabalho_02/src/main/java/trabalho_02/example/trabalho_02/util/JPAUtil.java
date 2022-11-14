package trabalho_02.example.trabalho_02.util;

import javax.persistence.*;

public class JPAUtil {
    private static final EntityManagerFactory emf = Persistence.createEntityManagerFactory("BancoDev");
    private static ThreadLocal<EntityManager> ems = new ThreadLocal<EntityManager>();

    public static EntityManager getEntityManager() {
        EntityManager em = ems.get();
        if (em == null) { 
            em = emf.createEntityManager();
            ems.set(em);
        } return em;
    }

    public static void closeEntityManager() {
        EntityManager em = ems.get();
        if (em != null) {
            EntityTransaction tx = em.getTransaction();
            if (tx.isActive()) {
                tx.commit();
            }
            em.close();
            ems.set(null);
        }
    }
}