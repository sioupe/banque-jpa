package fr.diginamic.entite;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;

import java.time.LocalDate;

@Entity
@Table (name = "assurance_vie")
public class AssuranceVie extends Compte{
    @Column(name = "date_fin")
    private LocalDate dateFin;
    @Column(name = "taux")
    private double taux;
    public AssuranceVie() {
        super();
    }

    public AssuranceVie(String numero, double solde, LocalDate dateFin, double taux) {
        super(numero, solde);
        this.dateFin = dateFin;
        this.taux = taux;
    }
}
