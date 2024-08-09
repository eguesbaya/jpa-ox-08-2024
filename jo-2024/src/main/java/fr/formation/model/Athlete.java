package fr.formation.model;

import java.util.List;

import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;
import jakarta.persistence.OneToMany;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.SuperBuilder;

@Entity
@DiscriminatorValue("0")
@Getter @Setter
@NoArgsConstructor
@SuperBuilder
public class Athlete extends Personne {
    @OneToMany(mappedBy = "athlete")
    private List<Medaille> medailles;
}
