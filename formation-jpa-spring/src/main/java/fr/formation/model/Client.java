package fr.formation.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
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
public class Client {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "cli_id")
    private int id;
    
    @Column(name = "cli_nom", length = 50, nullable = false)
    private String nom;
    
    @Column(name = "cli_prenom", length = 50)
    private String prenom;
    
    @Column(name = "cli_email", length = 150)
    private String email;

    @OneToOne
    @JoinColumn(name = "cli_livraison_id")
    private Adresse adresseLivraison;
}
