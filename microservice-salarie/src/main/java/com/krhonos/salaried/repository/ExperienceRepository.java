package com.krhonos.salaried.repository;

import com.krhonos.salaried.model.Experience;
import org.springframework.data.repository.CrudRepository;

public interface ExperienceRepository extends CrudRepository <Experience, Long> {
}
