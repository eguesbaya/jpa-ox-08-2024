package fr.formation.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import fr.formation.model.Jury;

public interface JuryRepository extends JpaRepository<Jury, String> {
    
}
