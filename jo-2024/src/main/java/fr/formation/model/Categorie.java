package fr.formation.model;

import java.util.List;

import org.hibernate.annotations.UuidGenerator;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "categorie")
@Getter @Setter
@NoArgsConstructor
@Builder @AllArgsConstructor
public class Categorie {
    @Id
    @UuidGenerator
    @Column(name = "cat_id")
    private String id;
    
    @Column(name = "cat_libelle", length = 50, nullable = false)
    private String libelle;

    @ManyToMany(mappedBy = "categories")
    private List<Sport> sports;
}
