package fr.formation.repo;

import java.math.BigDecimal;
import java.util.List;

import fr.formation.model.Produit;

public interface ProduitRepository extends Repository<Produit, Integer> {
    public List<Produit> findAllByPriceBetween(BigDecimal a, BigDecimal b);
}
