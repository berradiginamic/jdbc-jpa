package fr.digi.m0923;

import javax.persistence.*;
import java.util.List;

@Entity
public class Client {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nom;
    private String prenom;

    @OneToMany(mappedBy = "client")
    private List<Emprunte> empruntes;

    // Getter and Setter


    public String getPrenom() {
        return prenom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public List<Emprunte> getEmpruntes() {
        return empruntes;
    }

    public void setEmpruntes(List<Emprunte> empruntes) {
        this.empruntes = empruntes;
    }
}

