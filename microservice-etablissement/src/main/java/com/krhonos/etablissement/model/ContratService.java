package com.krhonos.etablissement.model;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "contrat__service")
public class ContratService {
    @Id @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "contrat_id")
    private long id;

    @Column(name = "service_id")
    private long serviceId;

    @Column(name = "contrat__service_debut")
    private LocalDate dateStart;

    @Column(name = "contrat__service_fin")
    private LocalDate dateEnd;

    public ContratService() {
    }

    public ContratService(long serviceId, LocalDate dateStart, LocalDate dateEnd) {
        this.serviceId = serviceId;
        this.dateStart = dateStart;
        this.dateEnd = dateEnd;
    }

    public ContratService(long id, long serviceId, LocalDate dateStart, LocalDate dateEnd) {
        this.id = id;
        this.serviceId = serviceId;
        this.dateStart = dateStart;
        this.dateEnd = dateEnd;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public long getServiceId() {
        return serviceId;
    }

    public void setServiceId(long serviceId) {
        this.serviceId = serviceId;
    }

    public LocalDate getDateStart() {
        return dateStart;
    }

    public void setDateStart(LocalDate dateStart) {
        this.dateStart = dateStart;
    }

    public LocalDate getDateEnd() {
        return dateEnd;
    }

    public void setDateEnd(LocalDate dateEnd) {
        this.dateEnd = dateEnd;
    }

    @Override
    public String toString() {
        return "ContratService{" +
                "id=" + id +
                ", serviceId=" + serviceId +
                ", dateStart=" + dateStart +
                ", dateEnd=" + dateEnd +
                '}';
    }
}
