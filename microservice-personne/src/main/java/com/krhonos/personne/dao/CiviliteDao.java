package com.krhonos.personne.dao;

import com.krhonos.personne.model.Civilite;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CiviliteDao extends JpaRepository<Civilite, Long> {
}
