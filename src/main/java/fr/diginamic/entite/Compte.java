package fr.diginamic.entite;

import jakarta.persistence.*;

@Entity
@Table(name = "compte")
public abstract class  Compte {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID")
    private Integer id;

    @Column(name = "NUMERO")
    private String numero;
    @Column(name = "SOLDE")
    private double solde;
    @Column(name = "taux")
    private double taux;
}
