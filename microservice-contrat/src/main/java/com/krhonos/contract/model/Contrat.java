package com.krhonos.contract.model;

import sun.util.calendar.BaseCalendar;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "contrats")
public class Contrat {
  @Id @GeneratedValue(strategy = GenerationType.AUTO)
  private long id;

  @Column(name = "nature_contrat")
  private String natureContrat;

  @Column(name = "intitulee_poste")
  private String nomPoste;

  @Column(name = "lieu_de_travail")
  private String lieuTravail;

  @Column(name = "date_embauche")
  private LocalDateTime dateEmbauche;

  @Column(name = "debut_embauche")
  private BaseCalendar.Date debutEmbauche;

  @Column(name = "duree_travail")
  private Integer dureeTravail;

  @Column(name = "fin")
  private LocalDateTime finContrat;

  @Column(name = "Nom_employeur")
  private String NomEmployeur;

  @Column(name = "droit_conges_payes")
  private Integer droitCongesPayes;

  public Contrat(String natureContrat, String nomPoste, String lieuTravail, LocalDateTime dateEmbauche, BaseCalendar.Date debutEmbauche, Integer dureeTravail, LocalDateTime finContrat, String nomEmployeur, Integer droitCongesPayes) {
    this.natureContrat = natureContrat;
    this.nomPoste = nomPoste;
    this.lieuTravail = lieuTravail;
    this.dateEmbauche = dateEmbauche;
    this.debutEmbauche = debutEmbauche;
    this.dureeTravail = dureeTravail;
    this.finContrat = finContrat;
    NomEmployeur = nomEmployeur;
    this.droitCongesPayes = droitCongesPayes;
  }

  public long getId() {
    return id;
  }

  public void setId(long id) {
    this.id = id;
  }

  public String getNatureContrat() {
    return natureContrat;
  }

  public void setNatureContrat(String natureContrat) {
    this.natureContrat = natureContrat;
  }

  public String getNomPoste() {
    return nomPoste;
  }

  public void setNomPoste(String nomPoste) {
    this.nomPoste = nomPoste;
  }

  public String getLieuTravail() {
    return lieuTravail;
  }

  public void setLieuTravail(String lieuTravail) {
    this.lieuTravail = lieuTravail;
  }

  public LocalDateTime getDateEmbauche() {
    return dateEmbauche;
  }

  public void setDateEmbauche(LocalDateTime dateEmbauche) {
    this.dateEmbauche = dateEmbauche;
  }

  public BaseCalendar.Date getDebutEmbauche() {
    return debutEmbauche;
  }

  public void setDebutEmbauche(BaseCalendar.Date debutEmbauche) {
    this.debutEmbauche = debutEmbauche;
  }

  public Integer getDureeTravail() {
    return dureeTravail;
  }

  public void setDureeTravail(Integer dureeTravail) {
    this.dureeTravail = dureeTravail;
  }

  public LocalDateTime getFinContrat() {
    return finContrat;
  }

  public void setFinContrat(LocalDateTime finContrat) {
    this.finContrat = finContrat;
  }

  public String getNomEmployeur() {
    return NomEmployeur;
  }

  public void setNomEmployeur(String nomEmployeur) {
    NomEmployeur = nomEmployeur;
  }

  public Integer getDroitCongesPayes() {
    return droitCongesPayes;
  }

  public void setDroitCongesPayes(Integer droitCongesPayes) {
    this.droitCongesPayes = droitCongesPayes;
  }

  @Override
  public String toString() {
    return "Contrat{" +
            "id=" + id +
            ", natureContrat='" + natureContrat + '\'' +
            ", nomPoste='" + nomPoste + '\'' +
            ", lieuTravail='" + lieuTravail + '\'' +
            ", dateEmbauche=" + dateEmbauche +
            ", debutEmbauche=" + debutEmbauche +
            ", dureeTravail=" + dureeTravail +
            ", finContrat=" + finContrat +
            ", NomEmployeur='" + NomEmployeur + '\'' +
            ", droitCongesPayes=" + droitCongesPayes +
            '}';
  }
}

