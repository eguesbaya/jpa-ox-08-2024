package fr.formation.model;

import jakarta.persistence.Column;
import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "classement")
@Getter @Setter
@NoArgsConstructor
@Builder @AllArgsConstructor
public class Classement {
    @EmbeddedId
    private ClassementId id;

    @Column(name = "cls_ordre")
    private int ordre;
}
