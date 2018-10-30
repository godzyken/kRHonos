package com.krhonos.contrat.model;

import javax.persistence.*;
import javax.validation.constraints.Size;
import java.util.Set;

@Entity
@Table(name = "service")
public class Service {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "service_id")
    private long id;

    @Column(name = "service_nom", nullable = false)
    @Size(max = 80)
    private String nom;

    @Column(name = "etab_id", nullable = false)
    private long etabId;

    @OneToMany(mappedBy = "service")
    private Set<ContratService> contratService;

    public Service() {
    }

    public Service(@Size(max = 80) String nom, long etabId, Set<ContratService> contratService) {
        this.nom = nom;
        this.etabId = etabId;
        this.contratService = contratService;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public long getEtabId() {
        return etabId;
    }

    public void setEtabId(long etabId) {
        this.etabId = etabId;
    }

    public Set<ContratService> getContratService() {
        return contratService;
    }

    public void setContratService(Set<ContratService> contratService) {
        this.contratService = contratService;
    }
}
