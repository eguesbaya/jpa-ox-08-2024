package fr.formation.model;

import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.SuperBuilder;

@Entity
@DiscriminatorValue("1")
@Getter @Setter
@NoArgsConstructor
@SuperBuilder
public class Jury extends Personne {
    
}
