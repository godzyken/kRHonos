package com.krhonos.salaried.controller;

import com.krhonos.salaried.dao.RoleDao;
import com.krhonos.salaried.dao.UtilisateurDao;
import com.krhonos.salaried.dao.UtilisateurRoleDao;
import com.krhonos.salaried.model.Role;
import com.krhonos.salaried.model.Utilisateur;
import com.krhonos.salaried.model.UtilisateurRole;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/api/role_utilisateur")
public class UtilisateurRoleController {

    @Autowired
    UtilisateurDao utilisateurDao;
    @Autowired
    RoleDao roleDao;
    @Autowired
    UtilisateurRoleDao utilisateurRoleDao;

    @PostMapping(value = "/create")
    public UtilisateurRole postUtilisateurRole(@RequestBody UtilisateurRole utilisateurRole){

        long utilisateurId = utilisateurRole.getUtilisateur().getId();

        Utilisateur utilisateur = new Utilisateur();
        if (utilisateurDao.findById(utilisateurId).isPresent()) {
            utilisateur = utilisateurDao.findById(utilisateurId).get();
        }

        long roleId = utilisateurRole.getRole().getId();

        Role role = new Role();
        if (roleDao.findById(utilisateurId).isPresent()) {
            role = roleDao.findById(utilisateurId).get();
        }

        UtilisateurRole _utilisateurRole =  utilisateurRoleDao.save(new UtilisateurRole(
                utilisateurRole.getDateDebut(),
                utilisateurRole.getDateFin(),
                utilisateur,
                role
        ));


        return _utilisateurRole;
    }
}
