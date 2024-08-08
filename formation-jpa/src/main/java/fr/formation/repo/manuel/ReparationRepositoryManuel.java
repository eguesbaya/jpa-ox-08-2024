package fr.formation.repo.manuel;

import java.util.List;
import java.util.Optional;

import fr.formation.model.Reparation;
import fr.formation.model.ReparationId;
import fr.formation.repo.ReparationRepository;

public class ReparationRepositoryManuel extends AbstractRepositoryManuel implements ReparationRepository {
    @Override
    public List<Reparation> findAll() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'findAll'");
    }

    @Override
    public Optional<Reparation> findById(ReparationId id) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'findById'");
    }

    @Override
    public Reparation save(Reparation entity) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'save'");
    }

    @Override
    public void deleteById(ReparationId id) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'deleteById'");
    }

    @Override
    public List<Reparation> findAllByProduitCommentaireNote(int note) {
        return em   .createQuery("select r from Reparation r join r.id.produit.commentaires c where c.note > ?1", Reparation.class)
                    .setParameter(1, note)
                    .getResultList()
        ;
    }
}
