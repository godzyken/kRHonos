package com.krhonos.personne.controller;

import com.krhonos.personne.dao.RoleDao;
import com.krhonos.personne.model.Role;
import com.krhonos.personne.service.ModelMapperService;
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

    @Autowired
    ModelMapperService modelMapperService;

    @GetMapping(value = "/role")
    public List<Role> getAllSalaried() {
        List<Role> roles = new ArrayList<>();
        roleDao.findAll().forEach(roles::add);

        return roles;
    }

    @GetMapping(value = "/role/{id}")
    public Role findById(@PathVariable long id) {

        if (roleDao.findById(id) != null) {
            return roleDao.findById(id);
        }
        return null;
    }

    @PostMapping(value = "/role/create")
    public Role createRole(@RequestBody Role role) {
        return roleDao.save(new Role(role.getLibelle()));
    }

    @PutMapping(value = "/role/update/{id}")
    public Role updateRole(@PathVariable long id, @RequestBody Role role) {
        Role _role = roleDao.findById(id);
        if (_role != null) {
            modelMapperService.map(role, _role);
            roleDao.save(_role);
        }
        return _role;
    }

    @DeleteMapping(value = "/role/delete/{id}")
    public void deleteRole(@PathVariable long id){
       roleDao.deleteById(id);
    }
}
