package fr.formation.model;

import jakarta.persistence.Column;
import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter @Setter
@NoArgsConstructor
@Builder @AllArgsConstructor
public class Reparation {
    @EmbeddedId
    private ReparationId id;

    @Column(name = "repa_resume")
    private String resume;
}
