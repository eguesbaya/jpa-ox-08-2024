package fr.formation;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

import fr.formation.model.Produit;
import fr.formation.model.Produit.Type;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

public class Application {
    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("FormationUnit");
        EntityManager em = emf.createEntityManager();

        // Produit produit = Produit.builder()
        //     .id(2000)
        //     .name("From JAVA 2233")
        //     // .price(new BigDecimal("1.15"))
        //     // .date(LocalDate.now())
        //     // .type(Type.BUSINESS)
        //     .build()
        // ;

        Produit produit = em.find(Produit.class, 1);

        System.out.println(produit.getId());
        
        em.getTransaction().begin();
        
        // em.persist(produit);
        // produit = em.merge(produit);
        em.remove(produit);

        em.getTransaction().commit();

        // em.getTransaction().begin();

        // produit.setName("PRODUIT MODIFIE");
        
        // em.merge(produit);

        // em.getTransaction().commit();
        
        System.out.println(produit.getId());

        
        List<Produit> produits = em.createQuery("select p from Produit p", Produit.class)
            .getResultList();

        System.out.println("J'ai " + produits.size() + " produits en base !");

        emf.close();
    }
}
