package fr.formation;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

import fr.formation.model.Adresse;
import fr.formation.model.Client;
import fr.formation.model.Commande;
import fr.formation.model.Commentaire;
import fr.formation.model.Fournisseur;
import fr.formation.model.Produit;
import fr.formation.model.Produit.Type;
import fr.formation.model.Reparateur;
import fr.formation.model.Reparation;
import fr.formation.model.ReparationId;
import fr.formation.repo.CommentaireRepository;
import fr.formation.repo.FournisseurRepository;
import fr.formation.repo.ProduitRepository;
import fr.formation.repo.ReparationRepository;
import fr.formation.repo.manuel.AbstractRepositoryManuel;
import fr.formation.repo.manuel.CommentaireRepositoryManuel;
import fr.formation.repo.manuel.FournisseurRepositoryManuel;
import fr.formation.repo.manuel.ProduitRepositoryManuel;
import fr.formation.repo.manuel.ReparationRepositoryManuel;
import jakarta.persistence.EntityManager;

public class Application {
    public static void main(String[] args) {
        ProduitRepository produitRepository = new ProduitRepositoryManuel();
        CommentaireRepository commentaireRepository = new CommentaireRepositoryManuel();
        FournisseurRepository fournisseurRepository = new FournisseurRepositoryManuel();
        ReparationRepository reparationRepository = new ReparationRepositoryManuel();

        // for (Produit produit : produitRepository.findAll()) {
        //     System.out.println(produit.getName());
        // }

        Optional<Produit> optProduit = produitRepository.findById(13);

        if (optProduit.isPresent()) {
            System.out.println(optProduit.get().getName());
            System.out.println(optProduit.get().getFournisseur().getName());
        }

        else {
            System.out.println("Produit non trouvé !");
        }

        for (Commentaire commentaire : commentaireRepository.findAllByClientAdresse("75000")) {
            System.out.println(commentaire.getNote() + " - " + commentaire.getTexte());
        }

        for (Fournisseur fournisseur : fournisseurRepository.findAllByProduitCommentaireNote(2)) {
            System.out.println(fournisseur.getName());
        }

        for (Reparation reparation : reparationRepository.findAllByProduitCommentaireNote(4)) {
            System.out.println(reparation.getId().getProduit().getName());
        }

        AbstractRepositoryManuel.close();

        // EntityManagerFactory emf = Persistence.createEntityManagerFactory("FormationUnit");
        // EntityManager em = emf.createEntityManager();

        // insertProduit(em);
        // insertFournisseur(em);
        // findAllProduits(em);
        // insertProduitAvecFournisseur(em);
        // findProduitById(em, 13);
        // findFournisseurById(em, 1);
        // insertCommande(em);
        
        // insertAdresse(em);
        // insertClient(em);
        // insertCommentaire(em);

        // insertReparateur(em);
        // insertReparation(em);

        // emf.close();
    }

    public static void insertProduit(EntityManager em) {
        Produit produit = Produit.builder()
            .name("From JAVA 2233")
            .price(new BigDecimal("1.15"))
            .date(LocalDate.now())
            .type(Type.BUSINESS)
            .build()
        ;

        System.out.println(produit.getId());
        
        em.getTransaction().begin();
        
        em.persist(produit);

        em.getTransaction().commit();

        System.out.println(produit.getId());
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

    public static void insertAdresse(EntityManager em) {
        Adresse adresse = Adresse.builder()
            .rue("6 Rue des Environs")
            .codePostal("53000")
            .ville("LAVAL")
            .build()
        ;

        em.getTransaction().begin();

        em.persist(adresse);

        em.getTransaction().commit();
    }

    public static void insertClient(EntityManager em) {
        Adresse adresse = em.find(Adresse.class, "be73bead-6750-4ff2-ae06-1dfae6afd0c9");

        Client client = Client.builder()
            .nom("PERROUAULT")
            .email("jeremy@oxiane.fr")
            .adresseLivraison(adresse)
            .build()
        ;

        em.getTransaction().begin();

        em.persist(client);

        em.getTransaction().commit();
    }

    public static void insertCommentaire(EntityManager em) {
        Client client = em.find(Client.class, 1);
        Produit produit = em.find(Produit.class, 11);

        Commentaire commentaire = Commentaire.builder()
            .date(LocalDateTime.now())
            .texte("Super produit !")
            .client(client)
            .produit(produit)
            .build()
        ;

        em.getTransaction().begin();

        em.persist(commentaire);

        em.getTransaction().commit();
    }

    public static void insertReparateur(EntityManager em) {
        Reparateur reparateur = Reparateur.builder()
            .nom("OXIANE")
            .build()
        ;

        em.getTransaction().begin();

        em.persist(reparateur);

        em.getTransaction().commit();
    }

    public static void insertReparation(EntityManager em) {
        Produit produit = em.find(Produit.class, 11);
        Reparateur reparateur = em.find(Reparateur.class, 1);

        Reparation reparation = Reparation.builder()
            .id(
                ReparationId.builder()
                    .produit(produit)
                    .reparateur(reparateur)
                    .date(LocalDate.now())
                   .build()
            )
            .resume("Réparation de test")
            .build()
        ;

        em.getTransaction().begin();

        em.persist(reparation);

        em.getTransaction().commit();
    }
}
