package com.krhonos.salaried.dao;

import com.krhonos.salaried.model.Experience;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ExperienceDao extends JpaRepository<Experience, Long> {
}
