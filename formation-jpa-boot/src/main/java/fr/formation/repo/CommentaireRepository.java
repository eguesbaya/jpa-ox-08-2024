package fr.formation.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import fr.formation.model.Commentaire;

public interface CommentaireRepository extends JpaRepository<Commentaire, String> {
    public List<Commentaire> findAllByClientAdresseLivraisonCodePostal(String codePostal);
}
