package fr.diginamic.Entities;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Inheritance(strategy = InheritanceType.JOINED)
public abstract class Compte {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(nullable = false, unique = true)
    private Integer id;

    @Column(nullable = false, unique = true)
    private String numero;

    @Column(nullable = false)
    private double solde;

    public Compte(){}

    @ManyToMany
    @JoinTable(name="client_compte", joinColumns = @JoinColumn(name="compte_id"), inverseJoinColumns = @JoinColumn(name="client_id"))
    private List<ClientBanque> clients = new ArrayList<>();

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNumero() {
        return numero;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }

    public double getSolde() {
        return solde;
    }

    public void setSolde(double solde) {
        this.solde = solde;
    }
}
