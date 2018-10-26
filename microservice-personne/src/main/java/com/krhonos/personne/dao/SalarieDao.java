package com.krhonos.salaried.dao;

import com.krhonos.salaried.model.Salarie;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SalarieDao extends JpaRepository<Salarie, Long> {
}
