package fr.formation.repo.manuel;

import java.util.List;
import java.util.Optional;

import fr.formation.model.Produit;
import fr.formation.repo.ProduitRepository;

public class ProduitRepositoryManuel extends AbstractRepositoryManuel implements ProduitRepository {
    @Override
    public List<Produit> findAll() {
        return em   .createQuery("select p from Produit p", Produit.class)
                    .getResultList();
    }

    @Override
    public Optional<Produit> findById(Integer id) {
        // Solution 1
        // return Optional.ofNullable(em.find(Produit.class, id));

        // Solution 2
        // Produit produit = em    .createQuery("select p from Produit p where p.id = ?1", Produit.class)
        //                         .setParameter(1, id)
        //                         .getSingleResult();

        // return Optional.ofNullable(produit);

        // Solution 3
        Produit produit = em    .createQuery("select p from Produit p where p.id = :identifiant", Produit.class)
                                .setParameter("identifiant", id)
                                .getSingleResult();

        return Optional.ofNullable(produit);
    }

    @Override
    public Produit save(Produit entity) {
        em.getTransaction().begin();

        try {
            if (entity.getId() > 0) { // UPDATE
                entity = em.merge(entity);
            }

            else { // INSERT
                em.persist(entity);
            }

            em.getTransaction().commit();
        }

        catch (Exception ex) {
            em.getTransaction().rollback();
        }

        return entity;
    }

    @Override
    public void deleteById(Integer id) {
        em.getTransaction().begin();

        try {
            // Solution 1
            // Produit produit = Produit.builder().id(id).build();
            // em.remove(em.merge(produit));

            // Solution 2
            this.findById(id).ifPresent(em::remove);

            em.getTransaction().commit();
        }

        catch (Exception ex) {
            em.getTransaction().rollback();
        }
    }
}
