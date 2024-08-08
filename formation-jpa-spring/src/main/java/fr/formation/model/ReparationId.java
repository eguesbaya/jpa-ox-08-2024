package fr.formation.model;

import java.io.Serializable;
import java.time.LocalDate;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Embeddable
@Getter @Setter
@NoArgsConstructor
@Builder @AllArgsConstructor
public class ReparationId implements Serializable {
    @ManyToOne
    @JoinColumn(name = "repa_reparateur_id")
    private Reparateur reparateur;
    
    @ManyToOne
    @JoinColumn(name = "repa_produit_id")
    private Produit produit;

    @Column(name = "repa_date")
    private LocalDate date;
}
