package fr.formation.model;

import java.util.List;

import org.hibernate.annotations.UuidGenerator;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "sport")
@Getter @Setter
@NoArgsConstructor
@Builder @AllArgsConstructor
public class Sport {
    @Id
    @UuidGenerator
    @Column(name = "spo_id")
    private String id;
    
    @Column(name = "spo_libelle", length = 50, nullable = false)
    private String libelle;

    @ManyToMany
    @JoinTable(
        name = "sport_categorie",
        joinColumns = @JoinColumn(name = "sport_id"),
        inverseJoinColumns = @JoinColumn(name = "categorie_id")
    )
    private List<Categorie> categories;

    @OneToMany(mappedBy = "sport")
    private List<Competition> competitions;
}
