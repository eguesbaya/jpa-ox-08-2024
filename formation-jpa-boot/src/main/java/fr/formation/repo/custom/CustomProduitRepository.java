package fr.formation.repo.custom;

import java.math.BigDecimal;
import java.util.List;

import fr.formation.model.Produit;

public interface CustomProduitRepository {
    public List<Produit> findAllByPriceBetween(BigDecimal a, BigDecimal b);
    public List<Produit> findAllByFournisseurId(int fournisseurId);
}
