package com.krhonos.auth.model;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "utilisateur")
public class Utilisateur {

    private Long id;
    private String utilisateurnom;
    private String password;
    private String passwordConfirme;
    private Set<Role> roles;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUtilisateurnom() {
        return utilisateurnom;
    }

    public void setUtilisateurnom(String utilisateurnom) {
        this.utilisateurnom = utilisateurnom;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Transient
    public String getPasswordConfirme() {
        return passwordConfirme;
    }

    public void setPasswordConfirme(String passwordConfirme) {
        this.passwordConfirme = passwordConfirme;
    }

    @ManyToMany
    @JoinTable(name = "utilisateur_role", joinColumns = @JoinColumn(name = "utilisateur_id"), inverseJoinColumns = @JoinColumn(name = "role_id"))
    public Set<Role> getRoles() {
        return roles;
    }

    public void setRoles(Set<Role> roles) {
        this.roles = roles;
    }
}
