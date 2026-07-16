package fr.diginamic.Entities;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Banque {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(nullable = false)
    private String nom;

    public Banque(){}

    @OneToMany(mappedBy = "banque")
    private List<ClientBanque> clients = new ArrayList<>();

    public List<ClientBanque> getClients() {
        return clients;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

}
