package fr.formation.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import fr.formation.model.Produit;
import fr.formation.repo.custom.CustomProduitRepository;

public interface ProduitRepository extends JpaRepository<Produit, Integer>, JpaSpecificationExecutor<Produit>, CustomProduitRepository {
    // public List<Produit> findAllByPriceBetween(BigDecimal a, BigDecimal b);

    // @Query("select p from Produit p where p.fournisseur.id = ?1")
    // public List<Produit> findAllByFournisseurId(int id);
}
