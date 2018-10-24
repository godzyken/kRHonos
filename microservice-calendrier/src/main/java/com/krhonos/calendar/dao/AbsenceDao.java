package com.krhonos.calendar.dao;

import com.krhonos.calendar.model.Absence;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AbsenceDao extends JpaRepository<Absence, Long> {
}
