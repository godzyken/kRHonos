package com.krhonos.etablissement.model;

import javax.persistence.*;
import java.util.Collection;

@Entity
public class Etablissement {
  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  @Column(name = "etab_id")
  private long id;

  @Column(name = "etab_nom")
  private String nom;

  @Column(name = "etab_siret")
  private String siret;

  @Column(name = "etab_adresse")
  private String adresse;

  @Column(name = "etab_code_postal")
  private String codePostal;

  @Column(name = "etab_ville")
  private String ville;

  @Column(name = "etab_numero")
  private String numero;

  @OneToMany(mappedBy = "etablissement")
  private Collection<Service> services;

  public Etablissement() {
  }

  public Etablissement(
          long id,
          String nom,
          String siret,
          String adresse,
          String codePostal,
          String ville,
          String numero) {
    this.id = id;
    this.nom = nom;
    this.siret = siret;
    this.adresse = adresse;
    this.codePostal = codePostal;
    this.ville = ville;
    this.numero = numero;
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

  public String getSiret() {
    return siret;
  }

  public void setSiret(String siret) {
    this.siret = siret;
  }

  public String getAdresse() {
    return adresse;
  }

  public void setAdresse(String adresse) {
    this.adresse = adresse;
  }

  public String getCodePostal() {
    return codePostal;
  }

  public void setCodePostal(String codePostal) {
    this.codePostal = codePostal;
  }

  public String getVille() {
    return ville;
  }

  public void setVille(String ville) {
    this.ville = ville;
  }

  public String getNumero() {
    return numero;
  }

  public void setNumero(String numero) {
    this.numero = numero;
  }

  @Override
  public String toString() {
    return "Etablissement{"
            + "id="
            + id
            + ", nom='"
            + nom
            + '\''
            + ", siret='"
            + siret
            + '\''
            + ", adresse='"
            + adresse
            + '\''
            + ", codePostal='"
            + codePostal
            + '\''
            + ", ville='"
            + ville
            + '\''
            + ", numero='"
            + numero
            + '\''
            + '}';
  }
}
