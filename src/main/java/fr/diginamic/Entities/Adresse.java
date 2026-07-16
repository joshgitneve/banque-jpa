package fr.diginamic.Entities;

import javax.persistence.Embeddable;

@Embeddable
public class Adresse {
    private Integer numero;
    private String rue;
    private Integer codePostal;
    private String ville;
}
