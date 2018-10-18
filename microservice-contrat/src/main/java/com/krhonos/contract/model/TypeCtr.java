package com.krhonos.contract.model;

import javax.persistence.*;

@Entity
@Table(name = "nature_contrat")
public class TypeCtr {
<<<<<<< HEAD
  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  @Column(name = "nature_ctr_id")
  private long id;

  @Column(name = "nature_ctr_libelle")
  private String typeLibelle;

  @Column(name = "nature_ctr_actif")
  private int typeActif;

  public TypeCtr() {}

  public TypeCtr(String typeLibelle, int typeActif) {
    this.typeLibelle = typeLibelle;
    this.typeActif = typeActif;
  }

  public TypeCtr(long id, String typeLibelle, int typeActif) {
    this.id = id;
    this.typeLibelle = typeLibelle;
    this.typeActif = typeActif;
  }

  public long getId() {
    return id;
  }

  public void setId(long id) {
    this.id = id;
  }

  public String getTypeLibelle() {
    return typeLibelle;
  }

  public void setTypeLibelle(String typeLibelle) {
    this.typeLibelle = typeLibelle;
  }

  public int getTypeActif() {
    return typeActif;
  }

  public void setTypeActif(int typeActif) {
    this.typeActif = typeActif;
  }

  @Override
  public String toString() {
    return "TypeCtr{"
        + "id="
        + id
        + ", typeLibelle='"
        + typeLibelle
        + '\''
        + ", typeActif="
        + typeActif
        + '}';
  }
=======
    @Id @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "nature_ctr_id")
    private long id;

    @Column(name = "nature_ctr_libelle")
    private String typeLibelle;

    @Column(name = "nature_ctr_actif")
    private int typeActif;

    public TypeCtr() {
    }

    public TypeCtr(String typeLibelle, int typeActif) {
        this.typeLibelle = typeLibelle;
        this.typeActif = typeActif;
    }

    public TypeCtr(long id, String typeLibelle, int typeActif) {
        this.id = id;
        this.typeLibelle = typeLibelle;
        this.typeActif = typeActif;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getTypeLibelle() {
        return typeLibelle;
    }

    public void setTypeLibelle(String typeLibelle) {
        this.typeLibelle = typeLibelle;
    }

    public int getTypeActif() {
        return typeActif;
    }

    public void setTypeActif(int typeActif) {
        this.typeActif = typeActif;
    }

    @Override
    public String toString() {
        return "TypeCtr{" +
                "id=" + id +
                ", typeLibelle='" + typeLibelle + '\'' +
                ", typeActif=" + typeActif +
                '}';
    }
>>>>>>> master
}
