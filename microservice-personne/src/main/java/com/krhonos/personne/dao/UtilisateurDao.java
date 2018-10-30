package com.krhonos.personne.dao;

import com.krhonos.personne.model.Utilisateur;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UtilisateurDao extends JpaRepository<Utilisateur, Long> {
}
