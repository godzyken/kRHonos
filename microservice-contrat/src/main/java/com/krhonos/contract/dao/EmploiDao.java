package com.krhonos.contract.dao;

import com.krhonos.contract.model.Emploi;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmploiDao extends JpaRepository<Emploi, Long> {
}
