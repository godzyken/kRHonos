package com.krhonos.salaried.model;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "salarie")
public class Salarie {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @Column(name = "salarie_nom")
    private String nom;

    @Column(name = "salarie_nom_naissance")
    private String nomNaissance;

    @Column(name = "salarie_prenom")
    private String prenom;

    @Column(name = "salarie_num_secu")
    private long numSecu;

    @Column(name = "salarie_cle_secu")
    private int cleSecu;

    @Column(name = "salarie_adresse")
    private String adresse;

    @Column(name = "salarie_code_postal")
    private int codePostal;

    @Column(name = "salarie_ville")
    private String ville;

    @Column(name = "salarie_telephone")
    private long telephone;

    @Column(name = "salarie_mail")
    private String mail;

    @Column(name = "salarie_date_naissance")
    private Date dateNaissance;

    @Column(name = "salarie_cp_naissance")
    private int cpNaissance;

    @Column(name = "salarie_ville_naissance")
    private String villeNaissance;

    @Column(name = "salarie_date_entree")
    private Date dateEntree;

    @Column(name = "civilite_id")
    private int civilite;

    @Column(name = "fam_id")
    private int situationFam;

    public Salarie(int id, String nom, String nomNaissance, String prenom, long numSecu, int cleSecu, String adresse,
                   int codePostal, String ville, long telephone, String mail, Date dateNaissance, int cpNaissance,
                   String villeNaissance, Date dateEntree, int civilite, int situationFam)
    {
        this.id = id;
        this.nom = nom;
        this.nomNaissance = nomNaissance;
        this.prenom = prenom;
        this.numSecu = numSecu;
        this.cleSecu = cleSecu;
        this.adresse = adresse;
        this.codePostal = codePostal;
        this.ville = ville;
        this.telephone = telephone;
        this.mail = mail;
        this.dateNaissance = dateNaissance;
        this.cpNaissance = cpNaissance;
        this.villeNaissance = villeNaissance;
        this.dateEntree = dateEntree;
        this.civilite = civilite;
        this.situationFam = situationFam;
    }

    public Salarie(String nom, String nomNaissance, String prenom, long numSecu, int cleSecu, String adresse,
                   int codePostal, String ville, long telephone, String mail, Date dateNaissance, int cpNaissance,
                   String villeNaissance, Date dateEntree, int civilite, int situationFam)
    {
        this.nom = nom;
        this.nomNaissance = nomNaissance;
        this.prenom = prenom;
        this.numSecu = numSecu;
        this.cleSecu = cleSecu;
        this.adresse = adresse;
        this.codePostal = codePostal;
        this.ville = ville;
        this.telephone = telephone;
        this.mail = mail;
        this.dateNaissance = dateNaissance;
        this.cpNaissance = cpNaissance;
        this.villeNaissance = villeNaissance;
        this.dateEntree = dateEntree;
        this.civilite = civilite;
        this.situationFam = situationFam;
    }


    public Salarie() {
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

    public String getNomNaissance() {
        return nomNaissance;
    }

    public void setNomNaissance(String nomNaissance) {
        this.nomNaissance = nomNaissance;
    }

    public String getPrenom() {
        return prenom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public long getNumSecu() {
        return numSecu;
    }

    public void setNumSecu(long numSecu) {
        this.numSecu = numSecu;
    }

    public int getCleSecu() {
        return cleSecu;
    }

    public void setCleSecu(int cleSecu) {
        this.cleSecu = cleSecu;
    }

    public String getAdresse() {
        return adresse;
    }

    public void setAdresse(String adresse) {
        this.adresse = adresse;
    }

    public int getCodePostal() {
        return codePostal;
    }

    public void setCodePostal(int codePostal) {
        this.codePostal = codePostal;
    }

    public String getVille() {
        return ville;
    }

    public void setVille(String ville) {
        this.ville = ville;
    }

    public long getTelephone() {
        return telephone;
    }

    public void setTelephone(long telephone) {
        this.telephone = telephone;
    }

    public String getMail() {
        return mail;
    }

    public void setMail(String mail) {
        this.mail = mail;
    }

    public Date getDateNaissance() {
        return dateNaissance;
    }

    public void setDateNaissance(Date dateNaissance) {
        this.dateNaissance = dateNaissance;
    }

    public int getCpNaissance() {
        return cpNaissance;
    }

    public void setCpNaissance(int cpNaissance) {
        this.cpNaissance = cpNaissance;
    }

    public String getVilleNaissance() {
        return villeNaissance;
    }

    public void setVilleNaissance(String villeNaissance) {
        this.villeNaissance = villeNaissance;
    }

    public Date getDateEntree() {
        return dateEntree;
    }

    public void setDateEntree(Date dateEntree) {
        this.dateEntree = dateEntree;
    }

    public int getCivilite() {
        return civilite;
    }

    public void setCivilite(int civilite) {
        this.civilite = civilite;
    }

    public int getSituationFam() {
        return situationFam;
    }

    public void setSituationFam(int situationFam) {
        this.situationFam = situationFam;
    }

    @Override
    public String toString() {
        return "Salarie{" +
                "id=" + id +
                ", nom='" + nom + '\'' +
                ", nomNaissance='" + nomNaissance + '\'' +
                ", prenom='" + prenom + '\'' +
                ", numSecu=" + numSecu +
                ", cleSecu=" + cleSecu +
                ", adresse='" + adresse + '\'' +
                ", codePostal=" + codePostal +
                ", ville='" + ville + '\'' +
                ", telephone=" + telephone +
                ", mail='" + mail + '\'' +
                ", dateNaissance=" + dateNaissance +
                ", cpNaissance=" + cpNaissance +
                ", villeNaissance='" + villeNaissance + '\'' +
                ", dateEntree=" + dateEntree +
                ", civilite=" + civilite +
                ", situationFam=" + situationFam +
                '}';
    }
}
