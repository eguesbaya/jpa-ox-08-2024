package fr.formation.model;

import java.math.BigDecimal;
import java.time.LocalDate;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "produit")
@Getter @Setter
@NoArgsConstructor
public class Produit {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    
    // @Column(name = "pro_name", columnDefinition = "VARCHAR(100) NOT NULL")
    @Column(name = "pro_name", length = 100, nullable = false)
    private String name;

    // @Transient
    private BigDecimal price;

    @Enumerated(EnumType.STRING)
    @Column(name = "pro_type")
    private Type type;

    // @Temporal
    // private Date date;

    private LocalDate date;

    public enum Type {
        BUSINESS, CUSTOMER;
    }
}
