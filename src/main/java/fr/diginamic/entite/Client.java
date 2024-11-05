package fr.diginamic.entite;

import jakarta.persistence.*;

import java.time.LocalDate;
import java.util.Set;

@Entity
@Table(name = "client")
public class Client {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID")
    private Integer id;

    @Column (name = "NOM")
    private String nom;
    @Column (name = "PRENOM")
    private String prenom;
    @Column (name = "DATE_NAISSANCE")
    private LocalDate dateNaissance;

    @Embedded
    private Adresse adresse;

    @OneToMany
    @JoinColumn(name = "BANQUE_ID")
    private Set<Banque> banques;

    @OneToMany
    @JoinColumn(name = "COMPTE_ID")
    private Set<Compte> comptes;
}
