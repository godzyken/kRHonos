package com.krhonos.securite.controller;

import com.krhonos.securite.config.JwtTokenUtil;
import com.krhonos.securite.model.Utilisateur;
import com.krhonos.securite.service.UtilisateurService;
import org.apache.tomcat.util.net.openssl.ciphers.Authentication;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/token")
public class AuthenticationController {

  @Autowired
  private AuthenticationManager authenticationManager;

  @Autowired
  private JwtTokenUtil jwtTokenUtil;

  @Autowired
  private UtilisateurService utilisateurService;

  @RequestMapping(value = "/generate-token", method = RequestMethod.POST)
  public ResponseEntity register(@RequestBody LoginUtilisateur loginUtilisateur) {
    final Authentication authentication = authenticationManager.authenticate(
            new UsernamePasswordAuthenticationToken(
                    loginUtilisateur.getUsername(),
                    loginUtilisateur.getPassword()
            )
    );
    SecurityContextHolder.getContext().setAuthentication(authentication);
    final Utilisateur utilisateur = utilisateurService.findOne(loginUtilisateur.getUsername());
    final String token = jwtTokenUtil.generateToken(utilisateur);
    return ResponseEntity.ok(new AuthToken(token));
  }

}
