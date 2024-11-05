package fr.diginamic.entite;

import jakarta.persistence.Embeddable;

@Embeddable
public class Adresse {
    private Integer numero;
    private String rue;
    private Integer codePostal;
    private String ville;

    public Adresse(Integer numero, String rue, Integer codePostal, String ville) {
        this.numero = numero;
        this.rue = rue;
        this.codePostal = codePostal;
        this.ville = ville;
    }
}
