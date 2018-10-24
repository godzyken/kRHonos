package com.krhonos.salaried.model;

import javax.persistence.*;


@Entity
@Table(name = "civilite")
public class Civilite {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "civilite_id")
    private long id;

    @Column(name = "civilite_identifiant")
    private String identifiant;

    @Column(name = "civilite_sexe")
    private String sexe;

    public Civilite() {
    }

    public Civilite(String identifiant, String sexe) {
        this.identifiant = identifiant;
        this.sexe = sexe;
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

    public String getSexe() {
        return sexe;
    }

    public void setSexe(String sexe) {
        this.sexe = sexe;
    }

    @Override
    public String toString() {
        return "Civilite{" +
                "id=" + id +
                ", identifiant='" + identifiant + '\'' +
                ", sexe='" + sexe + '\'' +
                '}';
    }
}
