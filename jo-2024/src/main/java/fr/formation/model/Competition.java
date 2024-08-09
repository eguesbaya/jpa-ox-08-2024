package fr.formation.model;

import java.time.LocalDateTime;
import java.util.List;

import org.hibernate.annotations.UuidGenerator;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "competition")
@Getter @Setter
@NoArgsConstructor
@Builder @AllArgsConstructor
public class Competition {
    @Id
    @UuidGenerator
    @Column(name = "comp_id")
    private String id;

    @Column(name = "comp_date")
    private LocalDateTime date;

    @ManyToOne
    @JoinColumn(name = "comp_sport_id")
    private Sport sport;

    @OneToMany
    private List<Classement> athletes;
    
    @ManyToMany
    @JoinTable(name = "jury")
    private List<Jury> juges;

    @OneToOne
    @JoinColumn(name = "comp_medaille_or_id")
    private Medaille medailleOr;

    @OneToOne
    @JoinColumn(name = "comp_medaille_argent_id")
    private Medaille medailleArgent;

    @OneToOne
    @JoinColumn(name = "comp_medaille_bronze_id")
    private Medaille medailleBronze;
}
