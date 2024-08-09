package fr.formation.model;

import jakarta.persistence.Embeddable;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.NoArgsConstructor;

@Embeddable
@NoArgsConstructor
@Builder @AllArgsConstructor
public class ClassementId {
    @ManyToOne
    @JoinColumn(name = "cls_athlete_id")
    private Athlete athlete;
    
    @ManyToOne
    @JoinColumn(name = "cls_competition_id")
    private Competition competition;
}
