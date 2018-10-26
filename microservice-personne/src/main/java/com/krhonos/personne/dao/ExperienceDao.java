package com.krhonos.personne.dao;

import com.krhonos.personne.model.Experience;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ExperienceDao extends JpaRepository<Experience, Long> {
}
