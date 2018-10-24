package com.krhonos.calendrier.dao;

import com.krhonos.calendrier.model.Absence;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AbsenceDao extends JpaRepository<Absence, Long> {
}
