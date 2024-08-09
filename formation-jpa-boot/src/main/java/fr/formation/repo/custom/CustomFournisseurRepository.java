package fr.formation.repo.custom;

import java.util.Optional;

import fr.formation.model.Fournisseur;

public interface CustomFournisseurRepository {
    public Optional<Fournisseur> findByCustom(int id);
}
