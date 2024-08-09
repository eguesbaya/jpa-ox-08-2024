package fr.formation.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import fr.formation.model.Competition;

public interface CompetitionRepository extends JpaRepository<Competition, String> {
    @Query("select c from Competition c join c.juges j join c.athletes ca where ca.ordre = 1 and j.nationalite = ca.id.athlete.nationalite")
    public List<Competition> findAllByJuryNationaliteIsAthleteNationalite();
}
