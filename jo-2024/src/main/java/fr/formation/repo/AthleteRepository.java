package fr.formation.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import fr.formation.model.Athlete;

public interface AthleteRepository extends JpaRepository<Athlete, String> {
    @Query("select a from Athlete a left join fetch a.medailles")
    public List<Athlete> findAllFetchMedailles();
}
