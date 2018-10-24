package com.krhonos.calendar.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import com.krhonos.calendar.model.Planning;

public interface PlanningDao extends JpaRepository<Planning, Long> {

}

