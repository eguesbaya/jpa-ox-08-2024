package fr.formation.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;

import fr.formation.model.Produit;

public interface ProduitRepository extends JpaRepository<Produit, Integer>, JpaSpecificationExecutor<Produit> {
    // public List<Produit> findAllByPriceBetween(BigDecimal a, BigDecimal b);

    @Query("select p from Produit p where p.fournisseur.id = ?1")
    public List<Produit> findAllByFournisseurId(int id);
}
