package com.krhonos.salaried.model;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Date;

@Entity
@Table(name = "salarie")
public class Salarie {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "salarie_id")
    private long id;

    @Column(name = "salarie_nom")
    private String nom;

    @Column(name = "salarie_nom_naissance", nullable = true)
    private String nomNaissance;

    @Column(name = "salarie_prenom")
    private String prenom;

    @Column(name = "salarie_num_secu")
    private String numSecu;

    @Column(name = "salarie_cle_secu")
    private int cleSecu;

    @Column(name = "salarie_adresse_numero")
    private String adresseNumero;

    @Column(name = "salarie_adresse_complement", nullable = true)
    private String adresseComplement;

    @Column(name = "salarie_adresse_latitude", precision = 15, scale = 13)
    private BigDecimal adresseLatitude;

    @Column(name = "salarie_adresse_longitude", precision = 15, scale = 13)
    private BigDecimal adresseLongitude;

    @Column(name = "salarie_telephone")
    private String telephone;

    @Column(name = "salarie_mail")
    private String mail;

    @Column(name = "salarie_date_naissance")
    private Date dateNaissance;

    @Column(name = "civilite_id")
    private int civilite;

    @ManyToOne
    @JoinColumn(name = "fam_id")
    private SituationFamiliale situationFam;

    public Salarie(String nom, String nomNaissance, String prenom, String numSecu, int cleSecu, String adresseNumero, String adresseComplement, BigDecimal adresseLatitude, BigDecimal adresseLongitude, String telephone, String mail, Date dateNaissance, int civilite, SituationFamiliale situationFam) {
        this.nom = nom;
        this.nomNaissance = nomNaissance;
        this.prenom = prenom;
        this.numSecu = numSecu;
        this.cleSecu = cleSecu;
        this.adresseNumero = adresseNumero;
        this.adresseComplement = adresseComplement;
        this.adresseLatitude = adresseLatitude;
        this.adresseLongitude = adresseLongitude;
        this.telephone = telephone;
        this.mail = mail;
        this.dateNaissance = dateNaissance;
        this.civilite = civilite;
        this.situationFam = situationFam;
    }

    public Salarie() {
    }

    public long getId() {
        return id;
    }

    public String getNumSecu() {
        return numSecu;
    }

    public void setNumSecu(String numSecu) {
        this.numSecu = numSecu;
    }

    public String getAdresseNumero() {
        return adresseNumero;
    }

    public void setAdresseNumero(String adresseNumero) {
        this.adresseNumero = adresseNumero;
    }

    public String getAdresseComplement() {
        return adresseComplement;
    }

    public void setAdresseComplement(String adresseComplement) {
        this.adresseComplement = adresseComplement;
    }

    public BigDecimal getAdresseLatitude() {
        return adresseLatitude;
    }

    public void setAdresseLatitude(BigDecimal adresseLatitude) {
        this.adresseLatitude = adresseLatitude;
    }

    public BigDecimal getAdresseLongitude() {
        return adresseLongitude;
    }

    public void setAdresseLongitude(BigDecimal adresseLongitude) {
        this.adresseLongitude = adresseLongitude;
    }

    public String getTelephone() {
        return telephone;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone;
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


    public int getCleSecu() {
        return cleSecu;
    }

    public void setCleSecu(int cleSecu) {
        this.cleSecu = cleSecu;
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


    public int getCivilite() {
        return civilite;
    }

    public void setCivilite(int civilite) {
        this.civilite = civilite;
    }


    public SituationFamiliale getSituationFam() {
        return situationFam;
    }

    public void setSituationFam(SituationFamiliale situationFam) {
        this.situationFam = situationFam;
    }
}
