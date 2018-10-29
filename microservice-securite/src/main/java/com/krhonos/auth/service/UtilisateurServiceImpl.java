package com.krhonos.auth.service;

import com.krhonos.auth.dao.RoleDao;
import com.krhonos.auth.dao.UtilisateurDao;
import com.krhonos.auth.model.Utilisateur;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.HashSet;

@Service
public class UtilisateurServiceImpl implements UtilisateurService {

    @Autowired
    private UtilisateurDao utilisateurDao;

    @Autowired
    private RoleDao roleDao;

//    @Autowired
    private BCryptPasswordEncoder bCryptPasswordEncoder;


    @Override
    public void save(Utilisateur utilisateur) {
        utilisateur.setPassword(bCryptPasswordEncoder.encode(utilisateur.getPassword()));
        utilisateur.setRoles(new HashSet<>(roleDao.findAll()));
        utilisateurDao.save(utilisateur);
    }

    @Override
    public Utilisateur findByUtilisateurnom(String utilisateurnom) {
        return utilisateurDao.findByUtilisateurnom(utilisateurnom);
    }
}
