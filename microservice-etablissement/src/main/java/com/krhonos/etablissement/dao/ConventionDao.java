package com.krhonos.etablissement.dao;

import com.krhonos.etablissement.model.Convention;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ConventionDao extends JpaRepository<Convention, Long> {
}
