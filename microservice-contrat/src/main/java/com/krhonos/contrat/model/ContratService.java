package com.krhonos.contrat.model;

import javax.persistence.*;
import java.time.LocalDate;
import java.io.Serializable;

@Entity
@Table(name = "contrat_service")
public class ContratService implements Serializable {

    private Service service;
    private Contrat contrat;

    @Column(name = "contrat_service_date_debut")
    private LocalDate dateDebut;

    @Column(name = "contrat_service_date_fin")
    private LocalDate dateFin;

    public ContratService() {
    }

    public ContratService(LocalDate dateDebut, LocalDate dateFin) {
        this.dateDebut = dateDebut;
        this.dateFin = dateFin;
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



    @Id
    @ManyToOne
    @JoinColumn(name = "service_id")
    public Service getService() {
        return service;
    }

    public void setService(Service service) {
        this.service = service;
    }

    @Id
    @ManyToOne
    @JoinColumn(name = "contrat_id")
    public Contrat getContrat() {
        return contrat;
    }

    public void setContrat(Contrat contrat) {
        this.contrat = contrat;
    }
}