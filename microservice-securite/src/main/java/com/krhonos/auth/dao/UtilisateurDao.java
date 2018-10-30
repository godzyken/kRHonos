package com.krhonos.auth.dao;

import com.krhonos.auth.model.Utilisateur;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UtilisateurDao extends JpaRepository<Utilisateur, Long> {

    Utilisateur findByUtilisateurnom(String utilisateurnom);
}
