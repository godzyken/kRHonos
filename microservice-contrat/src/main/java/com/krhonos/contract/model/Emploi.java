package com.krhonos.contract.model;

import javax.persistence.*;

@Entity
@Table(name = "emploi")
public class Emploi {
    @Id @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "emploi_id")
    private long id;

    @Column(name = "emploi_libelle")
    private String libelle;

    public Emploi() {
    }

    public Emploi(String libelle) {
        this.libelle = libelle;
    }

    public Emploi(long id, String libelle) {
        this.id = id;
        this.libelle = libelle;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getLibelle() {
        return libelle;
    }

    public void setLibelle(String libelle) {
        this.libelle = libelle;
    }

    @Override
    public String toString() {
        return "Emploi{" +
                "id=" + id +
                ", libelle='" + libelle + '\'' +
                '}';
    }
}
