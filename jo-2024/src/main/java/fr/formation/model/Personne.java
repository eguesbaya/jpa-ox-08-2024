package fr.formation.model;

import org.hibernate.annotations.UuidGenerator;

import jakarta.persistence.Column;
import jakarta.persistence.DiscriminatorColumn;
import jakarta.persistence.DiscriminatorType;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.Id;
import jakarta.persistence.Inheritance;
import jakarta.persistence.InheritanceType;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.SuperBuilder;

@Entity
@Table(name = "personne")
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name = "pers_type", discriminatorType = DiscriminatorType.INTEGER)
@Getter @Setter
@NoArgsConstructor
@SuperBuilder @AllArgsConstructor
public abstract class Personne {
    @Id
    @UuidGenerator
    @Column(name = "pers_id")
    protected String id;
    
    @Column(name = "pers_nom", length = 50, nullable = false)
    protected String nom;
    
    @Column(name = "pers_prenom", length = 50, nullable = false)
    protected String prenom;

    @Enumerated(EnumType.ORDINAL)
    @Column(name = "pers_nationalite", nullable = false)
    protected Nationalite nationalite;
    
    @ManyToOne
    @JoinColumn(name = "pers_sport_id")
    protected Sport sport;
    
    public enum Nationalite {
        FR, DE, ES, US;
    }
}
