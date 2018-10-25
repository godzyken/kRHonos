package com.krhonos.etablissement.dao;

import com.krhonos.etablissement.model.Emploi;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmploiDao extends JpaRepository<Emploi, Long> {
}
