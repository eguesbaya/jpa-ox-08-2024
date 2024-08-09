package fr.formation.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import fr.formation.model.Categorie;
import fr.formation.model.Personne.Nationalite;

public interface CategorieRepository extends JpaRepository<Categorie, String> {
    @Query("select c from Categorie c join c.sports s join s.competitions com join com.athletes ca where (ca.ordre >= 0 and ca.ordre <= 3) and ca.id.athlete.nationalite = ?1")
    public List<Categorie> findAllByMedaillesAndNationalite(Nationalite nationalite);
}
