package fr.formation.repo;

import java.util.Optional;

import fr.formation.model.Fournisseur;

public interface CustomFournisseurRepository {
    public Optional<Fournisseur> findByCustom(int id);
}
