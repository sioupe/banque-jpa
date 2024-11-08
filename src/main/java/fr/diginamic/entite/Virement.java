package fr.diginamic.entite;

import jakarta.persistence.*;

import java.time.LocalDateTime;

@Entity
@DiscriminatorValue("virement")
public class Virement extends Operation{
    @Column (name = "BENEFICIAIRE")
    private String beneficiaire;

    public Virement() {
    }

    public Virement(LocalDateTime date, String motif, double montant, String beneficiaire,Compte compte) {
        super(date, motif, montant,compte);
        this.beneficiaire = beneficiaire;
    }

    @Override
    public String toString() {

        final StringBuilder sb = new StringBuilder("Virement{ ");
        sb.append(super.toString());
        sb.append("beneficiaire= ").append(beneficiaire);

        sb.append('}');
        return sb.toString();
    }
}
