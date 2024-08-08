package fr.formation.repo.manuel;

import java.util.List;
import java.util.Optional;

import fr.formation.model.Fournisseur;
import fr.formation.repo.FournisseurRepository;

public class FournisseurRepositoryManuel extends AbstractRepositoryManuel implements FournisseurRepository {
    @Override
    public List<Fournisseur> findAll() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'findAll'");
    }

    @Override
    public Optional<Fournisseur> findById(Integer id) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'findById'");
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
