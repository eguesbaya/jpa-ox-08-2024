package fr.formation.repo.custom;

import java.util.Optional;

import org.springframework.stereotype.Repository;

import fr.formation.model.Fournisseur;
import fr.formation.repo.CustomFournisseurRepository;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;

@Repository
public class CustomFournisseurRepositoryImpl implements CustomFournisseurRepository {
    @PersistenceContext
    private EntityManager em;

    @Override
    public Optional<Fournisseur> findByCustom(int id) {
        return Optional.ofNullable(
            em  .createQuery("select f from Fournisseur f where f.id = ?1", Fournisseur.class)
                .setParameter(1, id)
                .getSingleResult()
        );
    }
}
