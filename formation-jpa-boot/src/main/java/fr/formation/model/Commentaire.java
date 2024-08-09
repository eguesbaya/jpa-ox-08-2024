package fr.formation.model;

import java.time.LocalDateTime;

import org.hibernate.annotations.UuidGenerator;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.Lob;
import jakarta.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter @Setter
@NoArgsConstructor
@Builder @AllArgsConstructor
public class Commentaire {
    @Id
    @UuidGenerator
    @Column(name = "com_id")
    private String id;

    @Column(name = "com_date", nullable = false)
    private LocalDateTime date;

    @Column(name = "com_texte", columnDefinition = "TEXT")
    // @Lob
    private String texte;

    @Column(name = "com_note", nullable = false)
    private int note;

    @ManyToOne
    @JoinColumn(name = "com_client_id", nullable = false)
    private Client client;

    @ManyToOne
    @JoinColumn(name = "com_produit_id", nullable = false)
    private Produit produit;
}
