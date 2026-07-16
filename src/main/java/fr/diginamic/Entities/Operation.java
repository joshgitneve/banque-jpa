package fr.diginamic.Entities;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Inheritance(strategy = InheritanceType.JOINED)
public abstract class Operation {

    @Id
    @GeneratedValue
    @Column(nullable = false, unique = true)
    private Integer id;
    private LocalDateTime date;
    private double montant;
    private String motif;


    public Operation(){}

    @ManyToOne
    @JoinColumn(name="compte_id")
    private Compte compte;

    public void setCompte(Compte compte) {
        this.compte = compte;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getMotif() {
        return motif;
    }

    public void setMotif(String motif) {
        this.motif = motif;
    }

    public double getMontant() {
        return montant;
    }

    public void setMontant(double montant) {
        this.montant = montant;
    }

    public LocalDateTime getDate() {
        return date;
    }

    public void setDate(LocalDateTime date) {
        this.date = date;
    }
}
