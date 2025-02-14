package fr.formation.repo.spring;

import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Repository;

import fr.formation.model.Produit;
import fr.formation.repo.ProduitRepository;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.transaction.Transactional;

@Repository
public class ProduitRepositorySpring implements ProduitRepository {
    @PersistenceContext
    private EntityManager em;

    @Override
    public List<Produit> findAll() {
        return em.createQuery("select p from Produit p", Produit.class).getResultList();
    }

    @Override
    public Optional<Produit> findById(Integer id) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'findById'");
    }

    @Override
    @Transactional
    public Produit save(Produit entity) {
        if (entity.getId() > 0) { // UPDATE
            entity = em.merge(entity);
        }

        else { // INSERT
            em.persist(entity);
        }

        return entity;
    }

    @Override
    public void deleteById(Integer id) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'deleteById'");
    }

    @Override
    public List<Produit> findAllByPriceBetween(BigDecimal a, BigDecimal b) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'findAllByPriceBetween'");
    }

    @Override
    public List<Produit> findAllByFournisseurId(int id) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'findAllByFournisseurId'");
    }
}
