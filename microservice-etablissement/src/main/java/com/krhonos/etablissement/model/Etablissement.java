package com.krhonos.etablissement.model;

import javax.persistence.*;
import javax.validation.constraints.Size;

@Entity
public class Etablissement {
  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  @Column(name = "etab_id")
  private long id;

    @Column(name = "etab_nom", nullable = false)
    @Size(max = 35)
    private String nom;

    @Column(name = "etab_siret", nullable = false)
    @Size(max = 20)
    private String siret;

    @JoinColumn(name="convention_id", nullable = false)
    @ManyToOne
    private Convention convention;

    public Etablissement() {
    }

    public Etablissement(@Size(max = 35) String nom, @Size(max = 20) String siret, Convention convention) {
        this.nom = nom;
        this.siret = siret;
        this.convention = convention;
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

    public Convention getConvention() {
        return convention;
    }

    public void setConvention(Convention convention) {
        this.convention = convention;
    }

}
