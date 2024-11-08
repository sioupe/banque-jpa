package fr.diginamic.entite;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;

import java.time.LocalDate;

@Entity
@Table(name = "assurance_vie")
public class AssuranceVie extends Compte{
    @Column(name = "DATE_FIN")
    private LocalDate dateFin;
    @Column(name = "TAUX")
    private double taux;

    /**
     * constructeur vide
     */
    public AssuranceVie() {
        super();
    }



    /**
     * constructeur parametre
     * @param numero
     * @param solde
     * @param dateFin
     * @param taux
     */
    public AssuranceVie(String numero, double solde, LocalDate dateFin, double taux) {
        super(numero, solde);
        this.dateFin = dateFin;
        this.taux = taux;

    }

    /**
     * affichage de tout sauf des listes
     * @return
     */
    @Override
    public String toString() {

        final StringBuilder sb = new StringBuilder("AssuranceVie{ ");
        sb.append(super.toString());
        sb.append("taux= ").append(taux);
        sb.append("dateFin ").append(dateFin);
        sb.append('}');
        return sb.toString();
    }
}
