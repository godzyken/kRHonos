package com.krhonos.etablissement.model;

import javax.persistence.*;

@Entity
public class Service {
  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  @Column(name = "service_id")
  private long id;

  @Column(name = "service_nom")
  private String nom;

  @Column(name = "etab_id")
  private long etabId;

  @ManyToOne
  private Etablissement etablissement;


  public Service() {
  }

  public Service(String nom, long etabId) {
    this.nom = nom;
    this.etabId = etabId;
  }

  public Service(long id, String nom, long etabId) {
    this.id = id;
    this.nom = nom;
    this.etabId = etabId;
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

  @Override
  public String toString() {
    return "Service{" + "id=" + id + ", nom='" + nom + '\'' + ", etabId=" + etabId + '}';
  }
}
