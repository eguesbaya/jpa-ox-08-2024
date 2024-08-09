package fr.formation.repo;

import java.util.List;

import fr.formation.model.Fournisseur;

public interface FournisseurRepository extends Repository<Fournisseur, Integer> {
    public List<Fournisseur> findAllByProduitCommentaireNote(int note);
}
