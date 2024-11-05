package fr.diginamic.entite;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;

@Entity
@Table (name = "virement")
public class Virement extends Operation{
    @Column (name = "BENEFICIAIRE")
    private String beneficiaire;
}
