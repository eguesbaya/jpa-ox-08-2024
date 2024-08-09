package fr.formation.repo;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import fr.formation.model.Personne.Nationalite;
import fr.formation.model.Sport;

public interface SportRepository extends JpaRepository<Sport, String> {
    public List<Sport> findAllByCompetitionsDateBefore(LocalDateTime date);

    @Query("select s from Sport s join s.competitions com join com.athletes ca where ca.ordre > 3 and ca.id.athlete.nationalite = ?1")
    public List<Sport> findAllByNotMedaillesAndNationalite(Nationalite nationalite);
}
