package fr.formation;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.stereotype.Component;

import fr.formation.model.Athlete;
import fr.formation.model.Categorie;
import fr.formation.model.Classement;
import fr.formation.model.ClassementId;
import fr.formation.model.Competition;
import fr.formation.model.Jury;
import fr.formation.model.Personne.Nationalite;
import fr.formation.model.Sport;
import fr.formation.repo.AthleteRepository;
import fr.formation.repo.CategorieRepository;
import fr.formation.repo.ClassementRepository;
import fr.formation.repo.CompetitionRepository;
import fr.formation.repo.JuryRepository;
import fr.formation.repo.SportRepository;
import lombok.RequiredArgsConstructor;

@Component
@RequiredArgsConstructor
public class DataGeneratorApplication {
    private final CategorieRepository categorieRepository;
    private final SportRepository sportRepository;

    private final AthleteRepository athleteRepository;
    private final JuryRepository juryRepository;

    private final CompetitionRepository competitionRepository;
    private final ClassementRepository classementRepository;

    public void run(String... args) {
        Categorie c1 = this.createCategorie("Combat");
        Categorie c2 = this.createCategorie("Gym");

        Sport escalade = this.createSport("Escalade", List.of(c1, c2));
        Sport judo = this.createSport("Judo", List.of(c1));

        Athlete a1 = this.createAthlete("PERROUAULT", "Jérémy", escalade);
        Athlete a2 = this.createAthlete("X", "Babar", judo);
        Athlete a3 = this.createAthlete("DUPONT", "Bernard", escalade);
        Athlete a4 = this.createAthlete("ALBERT", "Noémie", escalade);
        Athlete a5 = this.createAthlete("XXX", "Zoro", judo);

        Jury j1 = this.createJury("JUGE", "J1", escalade);
        Jury j2 = this.createJury("JUGE", "J2", escalade);
        Jury j3 = this.createJury("JUGE", "J3", judo);
        Jury j4 = this.createJury("JUGE", "J4", judo);

        this.createCompetition(LocalDateTime.of(2024, 8, 9, 11, 0), List.of(a1, a3, a4), List.of(j1, j2));
        this.createCompetition(LocalDateTime.of(2024, 8, 10, 15, 0), List.of(a2, a5), List.of(j3, j4));
    }

    private Categorie createCategorie(String libelle) {
        Categorie categorie = Categorie.builder().libelle(libelle).build();

        this.categorieRepository.save(categorie);

        return categorie;
    }

    private Sport createSport(String libelle, List<Categorie> categories) {
        Sport sport = Sport.builder().libelle(libelle).categories(categories).build();

        this.sportRepository.save(sport);

        return sport;
    }

    private Athlete createAthlete(String nom, String prenom, Sport sport) {
        Athlete athlete = Athlete.builder()
            .nom(nom)
            .prenom(prenom)
            .sport(sport)
            .nationalite(Nationalite.FR)
            .build()
        ;

        this.athleteRepository.save(athlete);

        return athlete;
    }

    private Jury createJury(String nom, String prenom, Sport sport) {
        Jury jury = Jury.builder()
            .nom(nom)
            .prenom(prenom)
            .sport(sport)
            .nationalite(Nationalite.FR)
            .build()
        ;
        
        this.juryRepository.save(jury);

        return jury;
    }

    private Competition createCompetition(LocalDateTime date, List<Athlete> athletes, List<Jury> juges) {
        Competition competition = Competition.builder()
            .date(date)
            .juges(juges)
            .build()
        ;

        List<Classement> classements = athletes.stream()
            .map(a -> Classement.builder()
                .id(ClassementId.builder()
                    .athlete(a)
                    .competition(competition)
                    .build()
                )
                .ordre(-1)
                .build()
            
            )
            .toList()
        ;
        
        this.competitionRepository.save(competition);
        this.classementRepository.saveAll(classements);

        return competition;
    }
}
