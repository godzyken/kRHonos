package com.krhonos.personne.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import java.util.Date;

@Entity
@Table(name = "candidat")
public class Candidat extends Personne {

  @Column(name = "candidat_date_dispo", columnDefinition = "DATE")
  private Date dateDispo;

  public Candidat() {
    super();
  }

  public Candidat(String nom, String nomNaissance, String prenom, Date dateDispo, Civilite civilite, long contactid) {
    super(nom, nomNaissance, prenom, civilite, contactid);
    this.dateDispo = dateDispo;
  }

  public Date getDateDispo() {
    return dateDispo;
  }

  public void setDateDispo(Date dateDispo) {
    this.dateDispo = dateDispo;
  }
}
