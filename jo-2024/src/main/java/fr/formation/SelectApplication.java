package fr.formation;

import java.time.LocalDateTime;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import fr.formation.model.Personne.Nationalite;
import fr.formation.repo.AthleteRepository;
import fr.formation.repo.CategorieRepository;
import fr.formation.repo.CompetitionRepository;
import fr.formation.repo.SportRepository;
import lombok.RequiredArgsConstructor;

@Component
@RequiredArgsConstructor
public class SelectApplication {
    private final AthleteRepository athleteRepository;
    private final SportRepository sportRepository;
    private final CategorieRepository categorieRepository;
    private final CompetitionRepository competitionRepository;

    public void run(String... args) {
        // Trouver les sportifs et leur médailles
        this.athleteRepository.findAllFetchMedailles();

        // Trouver tous les sports qui n'ont pas encore eu lieu
        this.sportRepository.findAllByCompetitionsDateBefore(LocalDateTime.now());

        // Trouver toutes les catégories qui ont des médailles
        this.categorieRepository.findAllByMedaillesAndNationalite(Nationalite.FR);

        // Trouver les sports où les français ne sont pas dans les 3 premiers
        this.sportRepository.findAllByNotMedaillesAndNationalite(Nationalite.FR);

        // Trouver les compétitions où au moins un des jurys a la même nationalité que le sportif arrivé premier
        this.competitionRepository.findAllByJuryNationaliteIsAthleteNationalite();
    }
}
