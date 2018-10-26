package com.krhonos.personne.dao;

import com.krhonos.personne.model.Diplome;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DiplomeDao extends JpaRepository<Diplome, Long> {
}
