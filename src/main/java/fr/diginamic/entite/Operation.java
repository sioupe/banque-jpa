package fr.diginamic.entite;

import jakarta.persistence.*;

import java.io.Serializable;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Set;

@Entity
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name = "TYPE")
@Table(name = "operation")
public abstract class Operation implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID")
    private Integer id;
    @Column(name = "DATE")
    private LocalDateTime date;
    @Column(name = "MONTANT")
    private double montant;
    @Column(name = "MOTIF")
    private String motif;

    @ManyToOne
    @JoinColumn(name = "COMPTE_ID")
    private Compte compte;
    /**
     * constructeur vide
     */
    public Operation(){

    }

    /**
     * constructeur parametre avec compte pour le 1 to many
     * @param date
     * @param motif
     * @param montant
     * @param compte
     */
    public Operation(LocalDateTime date, String motif, double montant,Compte compte) {
        this.date = date;
        this.motif = motif;
        this.montant = montant;
        setCompte(compte);
    }

    /**
     * Getter
     *
     * @return compte
     */

    public Compte getCompte() {
        return compte;
    }

    /**
     * Setter
     *
     * @param compte compte
     */


    public void setCompte(Compte compte) {
        if (this.compte != null) {
            this.compte.getOperations().remove(this);
        }
        this.compte = compte;
        if (this.compte != null) {
            this.compte.getOperations().add(this);
        }
    }

    /**
     * affichage de tout sauf des listes et du compte
     * @return
     */
    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder(" ");
        sb.append("id= ").append(id);
        sb.append(", date= ").append(date);
        sb.append(", montant= ").append(montant);
        sb.append(", motif= '").append(motif).append('\'');

        sb.append('}');
        return sb.toString();
    }
}
