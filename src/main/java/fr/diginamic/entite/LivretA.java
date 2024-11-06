package fr.diginamic.entite;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;

@Entity
@Table(name = "livret_A")
public class LivretA extends Compte{
    @Column  (name = "TAUX")
    private double taux;

    /**
     * constructeur vide
     */
    public LivretA() {
        super();
    }

    /**
     * constructeur parametre
     * @param numero
     * @param solde
     * @param taux
     */
    public LivretA(String numero, double solde, double taux) {
        super(numero, solde);
        this.taux = taux;
    }

    /**
     * affichage de tout sauf des listes
     * @return
     */
    @Override
    public String toString() {

        final StringBuilder sb = new StringBuilder("LivretA{ ");
        sb.append(super.toString());
        sb.append(" taux=").append(taux);
        sb.append('}');
        return sb.toString();
    }
}
