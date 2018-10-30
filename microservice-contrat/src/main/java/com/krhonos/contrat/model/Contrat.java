package com.krhonos.contrat.model;

import javax.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.Set;

@Entity
@Table(name = "contrat")
public class Contrat {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "contrat_id")
    private long id;

    @Column(name = "contrat_date_debut", nullable = false)
    private LocalDate dateDebut;

    @Column(name = "contrat_date_fin")
    private LocalDate dateFin;

    @Column(name = "contrat_tps_travail", nullable = false, precision = 5, scale = 2)
    private BigDecimal tempsTravail;

    @Column(name = "salarie_id", nullable = false)
    private long salarieId;

    @JoinColumn(name = "nature_ctr_id", nullable = false)
    @ManyToOne
    private NatureContrat natureContrat;

    @Column(name = "emploi_id", nullable = false)
    private long emploiId;

    @OneToMany(mappedBy = "contrat", cascade = CascadeType.ALL, orphanRemoval = true)
    private Set<ContratService> contratService;

    public Contrat() {
    }

    public Contrat(LocalDate dateDebut, LocalDate dateFin, BigDecimal tempsTravail, long salarieId, NatureContrat natureContrat, long emploiId, Set<ContratService> contratService) {
        this.dateDebut = dateDebut;
        this.dateFin = dateFin;
        this.tempsTravail = tempsTravail;
        this.salarieId = salarieId;
        this.natureContrat = natureContrat;
        this.emploiId = emploiId;
        this.contratService = contratService;
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

    public BigDecimal getTempsTravail() {
        return tempsTravail;
    }

    public void setTempsTravail(BigDecimal tempsTravail) {
        this.tempsTravail = tempsTravail;
    }

    public long getSalarieId() {
        return salarieId;
    }

    public void setSalarieId(long salarieId) {
        this.salarieId = salarieId;
    }

    public NatureContrat getNatureContrat() {
        return natureContrat;
    }

    public void setNatureContrat(NatureContrat natureContrat) {
        this.natureContrat = natureContrat;
    }

    public long getEmploiId() {
        return emploiId;
    }

    public void setEmploiId(long emploiId) {
        this.emploiId = emploiId;
    }

    public Set<ContratService> getContratService() {
        return contratService;
    }

    public void setContratService(Set<ContratService> contratService) {
        this.contratService = contratService;
    }
}