package com.krhonos.auth.service;

import com.krhonos.auth.dao.UtilisateurDao;
import com.krhonos.auth.model.Role;
import com.krhonos.auth.model.Utilisateur;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashSet;
import java.util.Set;

@Service
public class UtilisateurDetailsServiceImpl implements UserDetailsService {

    @Autowired
    private UtilisateurDao utilisateurDao;

    @Override
    @Transactional(readOnly = true)
    public UserDetails loadUserByUsername(String utilisateurnom) throws UsernameNotFoundException{

        Utilisateur user = utilisateurDao.findByUtilisateurnom(utilisateurnom);

        Set<GrantedAuthority> grantedAuthorities = new HashSet<>();
        for (Role role : user.getRoles()){
            grantedAuthorities.add(new SimpleGrantedAuthority(role.getNom()));
        }

        return new  org.springframework.security.core.userdetails.User(user.getUtilisateurnom(), user.getPassword(), grantedAuthorities);
    }
}
