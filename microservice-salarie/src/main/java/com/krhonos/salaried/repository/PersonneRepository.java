package com.krhonos.salaried.repository;

import com.krhonos.salaried.model.Personne;
import org.springframework.data.repository.CrudRepository;

public interface PersonneRepository extends CrudRepository<Personne, Long> {
}
