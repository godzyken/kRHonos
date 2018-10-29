package com.krhonos.auth.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class SecuriteServiceImpl implements SecuriteService{

    //    @Autowired
    private AuthenticationManager authenticationManager;

    @Resource
    private UserDetailsService userDetailsService;

    private static final Logger logger = LoggerFactory.getLogger(SecuriteServiceImpl.class);

    @Override
    public String findLoggedInUsername() {
        Object utilisateurDetails = SecurityContextHolder.getContext().getAuthentication().getDetails();
        if(utilisateurDetails instanceof UserDetails) {
            return ((UserDetails)utilisateurDetails).getUsername();
        }

        return null;
    }

    @Override
    public void autologin(String utilisateurnom, String password){

        UserDetails userDetails = userDetailsService.loadUserByUsername(utilisateurnom);
        UsernamePasswordAuthenticationToken usernamePasswordAuthenticationToken = new UsernamePasswordAuthenticationToken(userDetails, password, userDetails.getAuthorities());

        authenticationManager.authenticate(usernamePasswordAuthenticationToken);

        if(usernamePasswordAuthenticationToken.isAuthenticated()){
            SecurityContextHolder.getContext().setAuthentication(usernamePasswordAuthenticationToken);
            logger.debug(String.format("Auto login %s avec succèes !!", utilisateurnom));
        }
    }
}
