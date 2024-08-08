package fr.formation.repo;

import java.util.List;

import fr.formation.model.Reparation;
import fr.formation.model.ReparationId;

public interface ReparationRepository extends Repository<Reparation, ReparationId> {
    public List<Reparation> findAllByProduitCommentaireNote(int note);
}
