package com.krhonos.calendar.repository;

import com.krhonos.calendar.model.Absence;
import org.springframework.data.repository.CrudRepository;

public interface AbsenceRepository extends CrudRepository<Absence, Long> {
}
