package fr.diginamic.entite;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;

@Entity
@Table (name = "livret_a")
public class LivretA extends Compte{
    @Column  (name = "TAUX")
    private double taux;
}
