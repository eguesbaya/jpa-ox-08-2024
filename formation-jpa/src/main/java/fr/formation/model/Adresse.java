package fr.formation.model;

import org.hibernate.annotations.UuidGenerator;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter @Setter
@NoArgsConstructor
@Builder @AllArgsConstructor
public class Adresse {
    @Id
    @UuidGenerator
    @Column(name = "adr_id")
    private String id;
    
    @Column(name = "adr_rue", length = 150, nullable = false)
    private String rue;
    
    @Column(name = "adr_cp", length = 5, nullable = false)
    private String codePostal;
    
    @Column(name = "adr_ville", length = 100, nullable = false)
    private String ville;

    @OneToOne(mappedBy = "adresseLivraison", fetch = FetchType.LAZY)
    private Client clientLivraison;
}
