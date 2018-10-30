package com.krhonos.personne.model;


import javax.persistence.*;
import javax.validation.constraints.Size;
import java.util.Set;

@Entity
@Table(name = "utilisateur")
public class Utilisateur {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "utilisateur_id")
    private long id;

    @Column(name = "utilisateur_identifiant", nullable = false, unique = true)
    @Size(max = 50)
    private String identifiant;

    @Column(name = "utilisateur_mdp", nullable = false)
    @Size(max = 30)
    private String mdp;


    public Utilisateur() {
    }

    public Utilisateur(String identifiant, String mdp) {
        this.identifiant = identifiant;
        this.mdp = mdp;
    }


    public long getId() {
        return id;
    }

    public String getIdentifiant() {
        return identifiant;
    }

    public void setIdentifiant(String identifiant) {
        this.identifiant = identifiant;
    }

    public String getMdp() {
        return mdp;
    }

    public void setMdp(String mdp) {
        this.mdp = mdp;
    }


    @Override
    public String toString() {
        return "Utilisateur{" +
                "id=" + id +
                ", identifiant='" + identifiant + '\'' +
                ", mdp='" + mdp + '\'' +
                '}';
    }
}
