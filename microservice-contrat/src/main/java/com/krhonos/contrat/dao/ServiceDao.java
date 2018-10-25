package com.krhonos.contrat.dao;

import com.krhonos.contrat.model.Service;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ServiceDao extends JpaRepository<Service, Long> {
}
