package com.krhonos.personne.model;

import javax.persistence.*;
import javax.validation.constraints.Size;
import java.util.Set;

@Entity
@Table(name = "role")
public class Role {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "role_id")
    private long id;

    @Column(name = "role_libelle", nullable = false)
    @Size(max = 25)
    private String libelle;

    @Column(name = "colonne_test")
    private String testColonne;

    public Role() {
    }

    public Role(String libelle) {
        this.libelle = libelle;
    }

    public long getId() {
        return id;
    }

    public String getLibelle() {
        return libelle;
    }

    public void setLibelle(String libelle) {
        this.libelle = libelle;
    }

    public String getTestColonne() {
        return testColonne;
    }

    public void setTestColonne(String testColonne) {
        this.testColonne = testColonne;
    }

    @Override
    public String toString() {
        return "Role{" +
                "id=" + id +
                ", libelle='" + libelle + '\'' +
                '}';
    }
}
