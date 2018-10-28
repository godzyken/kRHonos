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
    @Size(max = 14)
    private String siret;

    @JoinColumn(name = "convention_id", nullable = false)
    @ManyToOne
    private Convention convention;

    @Column(name = "contact_id", unique = true)
    private long contactId;

    public Etablissement() {
    }

    public Etablissement(@Size(max = 35) String nom, @Size(max = 14) String siret, Convention convention, long contactId) {
        this.nom = nom;
        this.siret = siret;
        this.convention = convention;
        this.contactId = contactId;
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

    public void setSiret(String siret) {
        this.siret = siret;
    }

    public long getContactId() {
        return contactId;
    }

    public void setContactId(long contactId) {
        this.contactId = contactId;
    }
}
