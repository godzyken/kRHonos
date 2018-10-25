package com.krhonos.contrat.model;


import javax.persistence.*;

@Entity
@Table(name = "service")

public class Service {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)

    @Column(name = "service_id")
    private long id;

    @Column(name = "service_nom")
    private String nom;

    public Service() {
    }

    public Service(String nom) {
        this.nom = nom;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    @Override
    public String toString() {
        return "Service{" +
                "nom='" + nom + '\'' +
                '}';
    }

}
