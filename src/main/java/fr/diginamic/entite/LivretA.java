package fr.diginamic.entite;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;

@Entity
public class LivretA extends Compte{
    @Column  (name = "TAUX")
    private double taux;

    public LivretA() {
        super();
    }

    public LivretA(String numero, double solde, double taux) {
        super(numero, solde);
        this.taux = taux;
    }

    @Override
    public String toString() {

        final StringBuilder sb = new StringBuilder("LivretA{ ");
        sb.append(super.toString());
        sb.append(" taux=").append(taux);
        sb.append('}');
        return sb.toString();
    }
}
