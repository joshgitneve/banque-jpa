package fr.diginamic.Entities;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Virement extends Operation{

    private String beneficiaire;

    public Virement() {}

    public String getBeneficiaire() {
        return beneficiaire;
    }


    public void setBeneficiaire(String beneficiaire) {
        this.beneficiaire = beneficiaire;
    }
}
