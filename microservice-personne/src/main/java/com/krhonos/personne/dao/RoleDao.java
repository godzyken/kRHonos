package com.krhonos.personne.dao;

import com.krhonos.personne.model.Role;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RoleDao extends JpaRepository<Role, Long> {
}
