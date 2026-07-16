package fr.diginamic.Entities;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Entity
public class ClientBanque {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(nullable = false, unique = true)
    private Integer id;
    @Column(nullable = false)
    private String nom;
    @Column(nullable = false)
    private String prenom;
    @Column(nullable = false)
    private LocalDate dateNaissance;

    @Embedded
    private Adresse adresse;

    @ManyToOne
    @JoinColumn(name = "banque_id")
    private Banque banque;

    @ManyToMany
    @JoinTable(name="client_compte",joinColumns = @JoinColumn(name="client_id"), inverseJoinColumns = @JoinColumn(name="compte_id"))
    private List<Compte> comptes = new ArrayList<>();

    public ClientBanque(){}

    public List<Compte> getComptes() {
        return comptes;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getPrenom() {
        return prenom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public LocalDate getDateNaissance() {
        return dateNaissance;
    }

    public void setDateNaissance(LocalDate dateNaissance) {
        this.dateNaissance = dateNaissance;
    }
}
