package fr.formation.repo.manuel;

import java.util.List;
import java.util.Optional;

import fr.formation.model.Fournisseur;
import fr.formation.repo.FournisseurRepository;
import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Predicate;
import jakarta.persistence.criteria.Root;

public class FournisseurRepositoryManuel extends AbstractRepositoryManuel implements FournisseurRepository {
    @Override
    public List<Fournisseur> findAll() {
        CriteriaBuilder cb = em.getCriteriaBuilder();
        CriteriaQuery<Fournisseur> cq = cb.createQuery(Fournisseur.class);

        Root<Fournisseur> root = cq.from(Fournisseur.class);

        cq.select(root);

        return em.createQuery(cq).getResultList();
    }

    @Override
    public Optional<Fournisseur> findById(Integer id) {
        CriteriaBuilder cb = em.getCriteriaBuilder();
        CriteriaQuery<Fournisseur> cq = cb.createQuery(Fournisseur.class);

        Root<Fournisseur> root = cq.from(Fournisseur.class);

        cq.select(root);

        Predicate greaterThanZero = cb.greaterThan(root.get("id"), 0);
        Predicate equalsId = cb.equal(root.get("id"), id);

        Predicate andId = cb.and(greaterThanZero, equalsId);

        Predicate nameStartsWith = cb.like(root.get("name"), "AM%");

        Predicate idOrName = cb.or(andId, nameStartsWith);

        // cq.where(equalsId);
        // cq.where(andId);
        cq.where(idOrName);

        return Optional.ofNullable(
            em.createQuery(cq).getSingleResult()
        );
    }

    @Override
    public Fournisseur save(Fournisseur entity) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'save'");
    }

    @Override
    public void deleteById(Integer id) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'deleteById'");
    }

    @Override
    public List<Fournisseur> findAllByProduitCommentaireNote(int note) {
        return em   .createQuery("select f from Fournisseur f join fetch f.produits p join p.commentaires c where c.note < ?1", Fournisseur.class)
                    .setParameter(1, note)
                    .getResultList();
    }
}
