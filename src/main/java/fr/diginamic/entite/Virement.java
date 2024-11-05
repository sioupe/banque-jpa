package fr.diginamic.entite;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;

import java.time.LocalDateTime;

@Entity
@Table (name = "virement")
public class Virement extends Operation{
    @Column (name = "BENEFICIAIRE")
    private String beneficiaire;

    public Virement() {
    }

    public Virement(LocalDateTime date, String motif, double montant, String beneficiaire) {
        super(date, motif, montant);
        this.beneficiaire = beneficiaire;
    }
}
