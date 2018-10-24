package com.krhonos.calendar.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.krhonos.calendar.model.Planning;
import org.springframework.stereotype.Repository;

@Repository
public interface PlanningRepository extends JpaRepository<Planning, Long> {

}
