package com.krhonos.salaried.model;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "role")
public class Role {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "role_id")
    private long id;

    @Column(name = "role_libelle")
    private String libelle;

    @OneToMany(mappedBy = "role")
    private Set<UtilisateurRole> utilisateurRoles;

    public Role() {
    }

    public Role(String libelle) {
        this.libelle = libelle;
    }

    public Role(String libelle, Set<UtilisateurRole> utilisateurRoles) {
        this.libelle = libelle;
        this.utilisateurRoles = utilisateurRoles;
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


    public Set<UtilisateurRole> getUtilisateurRoles() {
        return utilisateurRoles;
    }

    public void setUtilisateurRoles(Set<UtilisateurRole> utilisateurRoles) {
        this.utilisateurRoles = utilisateurRoles;
    }

    @Override
    public String toString() {
        return "Role{" +
                "id=" + id +
                ", libelle='" + libelle + '\'' +
                '}';
    }
}
