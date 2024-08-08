package fr.formation.repo;

import java.util.List;

import fr.formation.model.Commentaire;

public interface CommentaireRepository extends Repository<Commentaire, String> {
    public List<Commentaire> findAllByClientAdresse(String codePostal);
}
