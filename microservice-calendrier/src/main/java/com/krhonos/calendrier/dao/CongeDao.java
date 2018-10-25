package com.krhonos.calendrier.dao;

import com.krhonos.calendrier.model.Conge;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CongeDao extends JpaRepository<Conge, Long> {
}
