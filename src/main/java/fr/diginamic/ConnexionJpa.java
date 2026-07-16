package fr.diginamic;

import fr.diginamic.Entities.*;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class ConnexionJpa {
    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("banque");
        EntityManager em = emf.createEntityManager();
        EntityTransaction transaction = em.getTransaction();

        transaction.begin();
        // create and persist Banque, linked to banque1
        Banque banque1 = new Banque();
        banque1.setNom("Crédit Mutuel");
        em.persist(banque1);

        // create and persist ClientBanque, linked to banque1
        ClientBanque cl1 = new ClientBanque();
        cl1.setNom("Johnson");
        cl1.setPrenom("Boris");
        cl1.setDateNaissance(LocalDate.parse("1964-05-19"));
        em.persist(cl1);


        ClientBanque cl2 = new ClientBanque();
        cl2.setNom("Thatcher");
        cl2.setPrenom("Maggie");
        cl2.setDateNaissance(LocalDate.parse("1925-10-13"));
        em.persist(cl2);

        //Link la banque avec les clients
        cl1.setBanque(banque1);
        cl2.setBanque(banque1);

        // create and persist a Compte, linked to client1 (ManyToMany)
        Compte compte1 = new LivretA();
        compte1.setNumero("FRLIVA123");
        compte1.setSolde(1000.0);
        cl1.getComptes().add(compte1);
        cl2.getComptes().add(compte1);
        em.persist(compte1);

        // insérer un client avec plusieurs comptes :
        Compte compte2 = new AssuranceVie();
        compte2.setNumero("FRAssV999");
        compte2.setSolde(19999.99);
        cl1.getComptes().add(compte2);
        em.persist(compte2);

        //insérer des opérations de type virements sur un compte
        Virement vir1 = new Virement();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm");
        vir1.setDate(LocalDateTime.parse("2026-07-15 17:24", formatter));
        vir1.setMontant(99.00);
        vir1.setMotif("Golden Ostrich");
        vir1.setBeneficiaire("Mother");
        vir1.setCompte(compte1);
        compte1.getOperations().add(vir1);
        em.persist(vir1);

        Virement vir2 = new Virement();
        vir2.setDate(LocalDateTime.parse("2026-07-16 15:02", formatter));
        vir2.setMontant(1009.00);
        vir2.setMotif("Gilet pour l'autruche");
        vir2.setBeneficiaire("l'Autruche: Gérard Déplumé");
        vir2.setCompte(compte1);
        compte1.getOperations().add(vir2);
        em.persist(vir2);

        // insérer des opérations de type opérations sur un compte
        // Pas possible - Operation est abstrait donc il faut passer par une classe fille.


        transaction.commit();





        System.out.println("Connexion établie, schéma généré.");

        em.close();
        emf.close();
    }
}
