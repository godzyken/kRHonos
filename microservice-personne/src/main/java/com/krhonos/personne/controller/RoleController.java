package com.krhonos.personne.controller;

import com.krhonos.personne.dao.RoleDao;
import com.krhonos.personne.model.Role;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/api")
public class RoleController {
    @Autowired
    RoleDao roleDao;

    @GetMapping(value = "/role")
    public List<Role> getAllSalaried() {
        List<Role> roles = new ArrayList<>();
        roleDao.findAll().forEach(roles::add);

        return roles;
    }

    @GetMapping(value = "/role/{id}")
    public Role findById(@PathVariable long id) {

        if (roleDao.findById(id).isPresent()) {
            return roleDao.findById(id).get();
        }
        return null;
    }
}
