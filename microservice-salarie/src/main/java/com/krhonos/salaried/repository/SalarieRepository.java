package com.krhonos.salaried.repository;

import com.krhonos.salaried.model.Salarie;
import org.springframework.data.repository.CrudRepository;

public interface SalarieRepository extends CrudRepository<Salarie, Long> {
}
