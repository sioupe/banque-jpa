package fr.diginamic.entite;

import jakarta.persistence.*;

import java.time.LocalDate;
import java.util.HashSet;
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

    @OneToMany(mappedBy = "client")
    private Set<Banque> banques;

    @ManyToMany
    @JoinTable(name = "possede",
            joinColumns = @JoinColumn(name = "ID_CLIENT",referencedColumnName = "ID"),
            inverseJoinColumns = @JoinColumn(name = "ID_COMPTES",referencedColumnName = "ID")
    )
    private Set<Compte>comptes;

    public Client(){
        banques=new HashSet<Banque>();
        comptes=new HashSet<Compte>();

    }
    public Client(String nom, String prenom, LocalDate dateNaissance, Adresse adresse) {
        banques=new HashSet<Banque>();
        comptes=new HashSet<Compte>();

        this.nom = nom;
        this.prenom = prenom;
        this.dateNaissance = dateNaissance;
        this.adresse = adresse;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Client{");
        sb.append("id=").append(id);
        sb.append(", nom='").append(nom).append('\'');
        sb.append(", prenom='").append(prenom).append('\'');
        sb.append(", dateNaissance=").append(dateNaissance);
        sb.append(", adresse=").append(adresse);
        sb.append('}');
        return sb.toString();
    }


}
