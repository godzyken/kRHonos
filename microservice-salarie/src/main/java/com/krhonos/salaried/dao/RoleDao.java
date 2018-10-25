package com.krhonos.salaried.dao;

import com.krhonos.salaried.model.Role;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RoleDao extends JpaRepository<Role, Long> {
}
