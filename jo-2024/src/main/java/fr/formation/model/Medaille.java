package fr.formation.model;

import org.hibernate.annotations.UuidGenerator;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "medaille")
@Getter @Setter
@NoArgsConstructor
@Builder @AllArgsConstructor
public class Medaille {
    @Id
    @UuidGenerator
    @Column(name = "med_id")
    private String id;

    @Enumerated(EnumType.STRING)
    @Column(name = "med_type")
    private Type type;

    @ManyToOne
    @JoinColumn(name = "med_athlete_id", nullable = false)
    private Athlete athlete;

    @ManyToOne
    @JoinColumn(name = "med_competition_id", nullable = false)
    private Competition competition;

    public enum Type {
        OR, ARGENT, BRONZE;
    }
}
