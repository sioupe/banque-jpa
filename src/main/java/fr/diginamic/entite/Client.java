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

    @ManyToOne
    @JoinColumn(name = "BANQUE_ID")
    private Banque banque;

    @ManyToMany
    @JoinTable(name = "possede",
            joinColumns = @JoinColumn(name = "ID_CLIENT",referencedColumnName = "ID"),
            inverseJoinColumns = @JoinColumn(name = "ID_COMPTES",referencedColumnName = "ID")
    )
    private Set<Compte>comptes;

    /**
     * constructeur vide
     */
    public Client(){
        comptes=new HashSet<Compte>();

    }

    /**
     * constructeur paramétré sans compte ou banque associer
     * @param nom
     * @param prenom
     * @param dateNaissance
     * @param adresse
     */
    public Client(String nom, String prenom, LocalDate dateNaissance, Adresse adresse) {
        comptes=new HashSet<Compte>();

        this.nom = nom;
        this.prenom = prenom;
        this.dateNaissance = dateNaissance;
        this.adresse = adresse;
    }

    /**
     * rajoute un compte dans l'entite client variable comptes
     * @param compte
     */
    public void addCompte(Compte compte){
        comptes.add(compte);
    }

    /**
     * setter
     * @param banque
     */
    public void setBanque(Banque banque){
        this.banque=banque;
        banque.addClient(this);
    }

    /**
     * Getter
     *
     * @return banques
     */

    public Banque getBanque() {
        return banque;
    }

    /**
     * affichage de tout sauf les listes
     * @return
     */
    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Client{");
        sb.append("id=").append(id);
        sb.append(", nom='").append(nom).append('\'');
        sb.append(", prenom='").append(prenom).append('\'');
        sb.append(", dateNaissance=").append(dateNaissance);
        sb.append(", adresse=").append(adresse);

        sb.append("}\n");
        return sb.toString();
    }


}
