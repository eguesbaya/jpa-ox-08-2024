package fr.formation.repo.manuel;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

public abstract class AbstractRepositoryManuel {
    private static final EntityManagerFactory emf = Persistence.createEntityManagerFactory("FormationUnit");
    protected static final EntityManager em = emf.createEntityManager();

    protected AbstractRepositoryManuel() { }

    public static void close() {
        emf.close();
    }
}
