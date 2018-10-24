package com.krhonos.contrat.model;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "contrat_service")
public class ContratService {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "contrat_id")
    private long id;

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

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
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

    @Override
    public String toString() {
        return "ContratService{" +
                "id=" + id +
                ", dateDebut=" + dateDebut +
                ", dateFin=" + dateFin +
                '}';
    }
}