package com.krhonos.salaried.model;


import javax.persistence.*;

@Entity
@Table(name = "utilisateur")
public class Utilisateur {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "utilisateur_id")
    private long id;

    @Column(name = "utilisateur_identifiant")
    private String identifiant;

    @Column(name = "utilisateur_mdp")
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

    public void setId(long id) {
        this.id = id;
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
