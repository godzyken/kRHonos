package com.krhonos.salaried.model;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Entity
@Table(name = "utilisateur_role")
public class UtilisateurRole implements Serializable {


    @Column(name = "utilisateur_role_date_debut")
    private Date dateDebut;

    @Column(name = "utilisateur_role_date_fin")
    private Date dateFin;

    private Utilisateur utilisateur;

    private Role role;

    public UtilisateurRole() {
    }

    public UtilisateurRole(Date dateDebut, Date dateFin, Utilisateur utilisateur, Role role) {
        this.dateDebut = dateDebut;
        this.dateFin = dateFin;
        this.utilisateur = utilisateur;
        this.role = role;
    }

    public Date getDateDebut() {
        return dateDebut;
    }

    public void setDateDebut(Date dateDebut) {
        this.dateDebut = dateDebut;
    }

    public Date getDateFin() {
        return dateFin;
    }

    public void setDateFin(Date dateFin) {
        this.dateFin = dateFin;
    }

    @Id
    @ManyToOne
    @JoinColumn(name = "utilisateur")
    public Utilisateur getUtilisateur() {
        return utilisateur;
    }

    public void setUtilisateur(Utilisateur utilisateur) {
        this.utilisateur = utilisateur;
    }

    @Id
    @ManyToOne
    @JoinColumn(name = "role")
    public Role getRole() {
        return role;
    }


    public void setRole(Role role) {
        this.role = role;
    }
}
