package com.krhonos.calendar.repository;

import org.springframework.data.repository.CrudRepository;
import com.krhonos.calendar.model.Planning;

public interface PlanningRepository extends CrudRepository<Planning, Long> {

}
