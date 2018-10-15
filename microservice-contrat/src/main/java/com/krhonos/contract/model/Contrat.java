package com.krhonos.contract.model;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "contrat")
public class Contrat {
  @Id @GeneratedValue(strategy = GenerationType.AUTO)
  @Column(name = "contrat_id")
  private long id;

  @Column(name = "contrat_date_debut")
  private LocalDate dateDebut;

  @Column(name = "contrat_date_fin")
  private LocalDate dateFin;

  @Column(name = "contrat_tps_travail")
  private float tempsTravail;

  @Column(name = "salarie_id")
  private int salarieId;

  @Column(name = "nature_ctr_id")
  private String natureCtrId;

  @Column(name = "emploi_id")
  private Integer emploiId;

  public Contrat() {
  }

  public Contrat(long id, LocalDate dateDebut, LocalDate dateFin, float tempsTravail, int salarieId, String natureCtrId, Integer emploiId) {
    this.id = id;
    this.dateDebut = dateDebut;
    this.dateFin = dateFin;
    this.tempsTravail = tempsTravail;
    this.salarieId = salarieId;
    this.natureCtrId = natureCtrId;
    this.emploiId = emploiId;
  }

  public Contrat(LocalDate dateDebut, LocalDate dateFin, float tempsTravail, int salarieId, String natureCtrId, Integer emploiId) {
    this.dateDebut = dateDebut;
    this.dateFin = dateFin;
    this.tempsTravail = tempsTravail;
    this.salarieId = salarieId;
    this.natureCtrId = natureCtrId;
    this.emploiId = emploiId;
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

  public float getTempsTravail() {
    return tempsTravail;
  }

  public void setTempsTravail(float tempsTravail) {
    this.tempsTravail = tempsTravail;
  }

  public int getSalarieId() {
    return salarieId;
  }

  public void setSalarieId(int salarieId) {
    this.salarieId = salarieId;
  }

  public String getNatureCtrId() {
    return natureCtrId;
  }

  public void setNatureCtrId(String natureCtrId) {
    this.natureCtrId = natureCtrId;
  }

  public Integer getEmploiId() {
    return emploiId;
  }

  public void setEmploiId(Integer emploiId) {
    this.emploiId = emploiId;
  }

  @Override
  public String toString() {
    return "Contrat{" +
            "id=" + id +
            ", dateDebut=" + dateDebut +
            ", dateFin=" + dateFin +
            ", tempsTravail=" + tempsTravail +
            ", salarieId=" + salarieId +
            ", natureCtrId='" + natureCtrId + '\'' +
            ", emploiId=" + emploiId +
            '}';
  }
}

