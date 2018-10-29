package com.krhonos.contrat.model;

import javax.persistence.*;
import java.time.LocalDate;
import java.io.Serializable;

@Entity
@Table(name = "contrat__service")
public class ContratService implements Serializable {

    @Id
    @ManyToOne
    @JoinColumn(name = "contrat_id")
    private Contrat contrat;

    @Id
    @ManyToOne
    @JoinColumn(name = "service_id")
    private Service service;

    @Column(name = "contrat_service_date_debut", nullable = false)
    private LocalDate dateDebut;

    @Column(name = "contrat_service_date_fin")
    private LocalDate dateFin;

    public ContratService() {
    }

    public ContratService(Contrat contrat, Service service, LocalDate dateDebut, LocalDate dateFin) {
        this.contrat = contrat;
        this.service = service;
        this.dateDebut = dateDebut;
        this.dateFin = dateFin;
    }

    public Contrat getContrat() {
        return contrat;
    }

    public void setContrat(Contrat contrat) {
        this.contrat = contrat;
    }

    public Service getService() {
        return service;
    }

    public void setService(Service service) {
        this.service = service;
    }

    public LocalDate getDateDebut() {
        return dateDebut;
    }

    public void setDateDebut(LocalDate dateDebut) {
        this.dateDebut = dateDebut;
    }

    public LocalDate getDateFin() {
        return dateFin;
    }

    public void setDateFin(LocalDate dateFin) {
        this.dateFin = dateFin;
    }
}