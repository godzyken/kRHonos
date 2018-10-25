package com.krhonos.etablissement.dao;

import com.krhonos.etablissement.model.Grille;
import org.springframework.data.jpa.repository.JpaRepository;

public interface GrilleDao extends JpaRepository<Grille, Long> {
}
