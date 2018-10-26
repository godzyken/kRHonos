package com.krhonos.contrat.model;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "service")
public class Service {

    @OneToMany(mappedBy = "service", cascade = CascadeType.ALL, orphanRemoval = true)
    private Set<ContratService> contratService;

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

    public Set<ContratService> getContratService() {
        return contratService;
    }

    public void setContratService(Set<ContratService> contratService) {
        this.contratService = contratService;
    }
}
