package com.krhonos.securite.beans;

public class PersonneBean {

  private int id;

  private String nom;

  private String nom_naissance;

  private String prenom;


  public PersonneBean() {
  }

  public PersonneBean(String nom, String nom_naissance, String prenom) {
    this.nom = nom;
    this.nom_naissance = nom_naissance;
    this.prenom = prenom;
  }

  public PersonneBean(int id, String nom, String nom_naissance, String prenom) {
    this.id = id;
    this.nom = nom;
    this.nom_naissance = nom_naissance;
    this.prenom = prenom;
  }

  public int getId() {
    return id;
  }

  public void setId(int id) {
    this.id = id;
  }

  public String getNom() {
    return nom;
  }

  public void setNom(String nom) {
    this.nom = nom;
  }

  public String getNom_naissance() {
    return nom_naissance;
  }

  public void setNom_naissance(String nom_naissance) {
    this.nom_naissance = nom_naissance;
  }

  public String getPrenom() {
    return prenom;
  }

  public void setPrenom(String prenom) {
    this.prenom = prenom;
  }

  @Override
  public String toString() {
    return "PersonneBean{" +
            "id=" + id +
            ", nom='" + nom + '\'' +
            ", nom_naissance='" + nom_naissance + '\'' +
            ", prenom='" + prenom + '\'' +
            '}';
  }

}
