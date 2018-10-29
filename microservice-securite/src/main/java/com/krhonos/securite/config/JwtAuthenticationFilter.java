package com.krhonos.securite.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
import org.springframework.web.filter.OncePerRequestFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Arrays;

public class JwtAuthenticationFilter extends OncePerRequestFilter {

  @Autowired
  private UtilisateurDetailsService utilisateurDetailsService;

  @Autowired
  private JwtTokenUtil jwtTokenUtil;

  @Override
  protected void doFilterIntenal(HttpServletRequest req, HttpServletResponse response, FilterChain chain) throws IOException,
          ServletException {
    String header = req.getHeader(HEADER_STRING);
    String username = null;
    String authToken = null;
    if (header != null && header.startsWith(TOKEN_PREFIX)) {
      authToken = header.replace(TOKEN_PREFIX, "");
      try {
        username = jwtTokenUtil.getUtilisateurnameFromToken(authToken);
      } catch (illegalArgumentException e) {
        logger.error("une erreur c'est produite durant la recherche de la clé utilisateur", e);
      } catch (ExpiredJwtException e) {
        logger.warn("la clé est expiré et n'est plus valide", e);
      }
    } else {
      logger.warn("couldn't find bearer string, will ignore the header");
    }
    if (username != null && SecurityContextHolder.getContext().getAuthentication() == null) {
      UtilisateurDetails utilisateurDetails = utilisateurDetailsService.loadUserByUsername(username);
      if (jwtTokenUtil.validateToken(authToken, utilisateurDetails)) {
        UsernamePasswordAuthenticationToken authentication = new UsernamePasswordAuthenticationToken(utilisateurDetails, null, Arrays.asList(new SimpleGrantedAuthority("ROLE_ADMIN")));
        authentication.setDetails(new WebAuthenticationDetailsSource().buildDetails(req));
        logger.info("authenticated user " + username + ", setting security context");
        SecurityContextHolder.getContext().setAuthentication(authentication);
      }
    }
    chain.doFilter(req, res);
  }

}
}
