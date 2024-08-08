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
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'findById'");
    }

    @Override
    public Produit save(Produit entity) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'save'");
    }

    @Override
    public void deleteById(Integer id) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'deleteById'");
    }
}
