package fr.digi.m0923;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.util.List;

public class TestBibliotheque {

    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("biblio-pu");
        EntityManager em = emf.createEntityManager();

        // Réalisez une requête qui permet d'extraire un emprunte et tous ses livres associés.
        Long emprunteId = 1L;
        Emprunte emprunte = em.find(Emprunte.class, emprunteId);
        System.out.println("Emprunte ID: " + emprunte.getId());
        System.out.println("Client: " + emprunte.getClient().getNom());
        System.out.println("Livres associés: " + emprunte.getLivres());

        // Réalisez une requête qui permet d'extraire tous les emprunts d'un client donné.
        Long clientId = 1L;
        Client client = em.find(Client.class, clientId);
        List<Emprunte> empruntesDuClient = client.getEmpruntes();
        System.out.println("Emprunts du client " + client.getNom() + ": " + empruntesDuClient);

        em.close();
        emf.close();
    }
}
