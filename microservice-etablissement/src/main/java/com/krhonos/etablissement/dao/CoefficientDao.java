package com.krhonos.etablissement.dao;

import com.krhonos.etablissement.model.Coefficient;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CoefficientDao extends JpaRepository<Coefficient, Long> {
}
