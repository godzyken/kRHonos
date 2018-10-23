package com.krhonos.etablissement.model;

import javax.persistence.*;
import javax.validation.constraints.Size;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "etablissement")
public class Etablissement {
    @Id @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "etab_id")
    private long id;

    @Column(name = "etab_nom")
    @Size(max = 35)
    private String nom;

    @Column(name = "etab_siret")
    @Size(max = 20)
    private String siret;

    @JoinColumn(name="convention_id")
    @ManyToOne
    private Convention convention;

    public Etablissement() {
    }

    public Etablissement(@Size(max = 35) String nom, @Size(max = 20) String siret, Convention convention) {
        this.nom = nom;
        this.siret = siret;
        this.convention = convention;
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

    public Convention getConvention() {
        return convention;
    }

    public void setConvention(Convention convention) {
        this.convention = convention;
    }

}
