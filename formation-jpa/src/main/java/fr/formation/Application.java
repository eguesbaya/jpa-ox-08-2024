package fr.formation;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

import javax.swing.text.html.parser.Entity;

import fr.formation.model.Commande;
import fr.formation.model.Fournisseur;
import fr.formation.model.Produit;
import fr.formation.model.Produit.Type;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

public class Application {
    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("FormationUnit");
        EntityManager em = emf.createEntityManager();

        Produit produit = Produit.builder()
            .name("From JAVA 2233")
            // .price(new BigDecimal("1.15"))
            // .date(LocalDate.now())
            // .type(Type.BUSINESS)
            .build()
        ;

        // System.out.println(produit.getId());
        
        em.getTransaction().begin();
        
        em.persist(produit);

        em.getTransaction().commit();

        // // em.getTransaction().begin();

        // // produit.setName("PRODUIT MODIFIE");
        
        // // em.merge(produit);

        // // em.getTransaction().commit();
        
        // System.out.println(produit.getId());

        // insertFournisseur(em);
        findAllProduits(em);
        // insertProduitAvecFournisseur(em);
        // findProduitById(em, 13);
        // findFournisseurById(em, 1);
        // insertCommande(em);
        
        emf.close();
    }

    public static void insertFournisseur(EntityManager em) {
        Fournisseur fournisseur = Fournisseur.builder()
            .name("AMAZON")
            .build()
        ;

        try {
            em.getTransaction().begin();
    
            em.persist(fournisseur);

            em.getTransaction().commit();
        }

        catch (Exception ex) {
            em.getTransaction().rollback();
        }
    }

    public static void insertProduitAvecFournisseur(EntityManager em) {
        Fournisseur fournisseur = em.find(Fournisseur.class, 1);

        Produit produit = Produit.builder()
            .name("Livre de chevet")
            .price(new BigDecimal("50"))
            .type(Type.BUSINESS)
            .date(LocalDate.now())
            .fournisseur(fournisseur)
            .build()
        ;

        em.getTransaction().begin();

        em.persist(produit);

        em.getTransaction().commit();
    }

    public static void insertCommande(EntityManager em) {
        Produit produit1 = em.find(Produit.class, 13);
        Produit produit2 = Produit.builder().id(11).build();

        Commande commande = Commande.builder()
            .date(LocalDateTime.now())
            .produits(List.of(produit1, produit2))
            .build()
        ;

        em.getTransaction().begin();

        em.persist(commande);

        em.getTransaction().commit();
    }

    public static void findProduitById(EntityManager em, int id) {
        Produit produit = em.find(Produit.class, id);

        System.out.println(produit.getName() + " fourni par " + produit.getFournisseur().getName());
    }

    public static void findFournisseurById(EntityManager em, int id) {
        Fournisseur fournisseur = em.find(Fournisseur.class, id);

        System.out.println(fournisseur.getName() + " fourni " + fournisseur.getProduits().size() + " produits");
    }

    public static void findAllProduits(EntityManager em) {
        List<Produit> produits = em.createQuery("select p from Produit p", Produit.class)
            .getResultList();

        System.out.println("J'ai " + produits.size() + " produits en base !");
    }
}
