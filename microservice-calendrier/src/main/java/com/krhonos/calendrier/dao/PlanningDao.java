package com.krhonos.calendrier.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import com.krhonos.calendrier.model.Planning;

public interface PlanningDao extends JpaRepository<Planning, Long> {

}

