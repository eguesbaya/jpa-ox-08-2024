package fr.formation.repo.custom;

import java.math.BigDecimal;
import java.util.List;

import org.springframework.stereotype.Repository;

import fr.formation.model.Fournisseur;
import fr.formation.model.Produit;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Join;
import jakarta.persistence.criteria.JoinType;
import jakarta.persistence.criteria.Predicate;
import jakarta.persistence.criteria.Root;

@Repository
public class CustomProduitRepositoryImpl implements CustomProduitRepository {
    @PersistenceContext
    private EntityManager em;

    @Override
    public List<Produit> findAllByPriceBetween(BigDecimal a, BigDecimal b) {
        CriteriaBuilder cb = em.getCriteriaBuilder();
        CriteriaQuery<Produit> cq = cb.createQuery(Produit.class);
        Root<Produit> root = cq.from(Produit.class);

        // Predicate fromA = cb.greaterThanOrEqualTo(root.get("price"), a);
        // Predicate fromB = cb.lessThanOrEqualTo(root.get("price"), b);
        // Predicate between = cb.and(fromA, fromB);

        Predicate between = cb.between(root.get("price"), a, b);

        cq  .select(root)
            .where(between)
        ;

        return em.createQuery(cq).getResultList();
    }

    @Override
    public List<Produit> findAllByFournisseurId(int fournisseurId) {
        CriteriaBuilder cb = em.getCriteriaBuilder();
        CriteriaQuery<Produit> cq = cb.createQuery(Produit.class);
        Root<Produit> root = cq.from(Produit.class);

        // root.fetch("fournisseur", JoinType.LEFT);
        Join<Produit, Fournisseur> joinFournisseur = root.join("fournisseur", JoinType.LEFT);

        Predicate idEquals = cb.equal(joinFournisseur.get("id"), fournisseurId);

        cq  .select(root)
            .where(idEquals)
        ;

        return em.createQuery(cq).getResultList();
    }
}
