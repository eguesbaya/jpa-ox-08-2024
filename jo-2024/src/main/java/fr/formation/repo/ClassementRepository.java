package fr.formation.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import fr.formation.model.Classement;
import fr.formation.model.ClassementId;

public interface ClassementRepository extends JpaRepository<Classement, ClassementId> {
    
}
