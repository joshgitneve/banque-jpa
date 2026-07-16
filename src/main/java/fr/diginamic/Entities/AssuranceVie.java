package fr.diginamic.Entities;

import javax.persistence.Entity;
import java.time.LocalDate;

@Entity
public class AssuranceVie extends Compte{

    private LocalDate dateFin;
    private double taux;

    public AssuranceVie(){}

    public LocalDate getDateFin() {
        return dateFin;
    }

    public void setDateFin(LocalDate dateFin) {
        this.dateFin = dateFin;
    }

    public double getTaux() {
        return taux;
    }

    public void setTaux(double taux) {
        this.taux = taux;
    }
}
