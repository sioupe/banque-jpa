package fr.diginamic.entite;

import jakarta.persistence.*;

@Entity
@Table(name="banque")
public class Banque {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID")
    private Integer id;
    @Column (name = "NOM")
    private String nom;

    @OneToMany(mappedBy = "banques")
    private Client client;
}
