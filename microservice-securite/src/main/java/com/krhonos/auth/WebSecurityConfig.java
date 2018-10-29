package com.krhonos.auth;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

<<<<<<< HEAD
import javax.annotation.Resource;

@EnableGlobalMethodSecurity(prePostEnabled = true)
=======
//@EnableGlobalMethodSecurity(prePostEnabled = true)
>>>>>>> godzyken
@Configuration
@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

<<<<<<< HEAD
  @Resource(name = "userService")
=======
  //  @Resource(name = "userService")
>>>>>>> godzyken
  @Autowired
  private UserDetailsService userDetailsService;

  @Bean
  public BCryptPasswordEncoder bCryptPasswordEncoder() {
    return new BCryptPasswordEncoder();
  }

  @Override
  @Bean
  public AuthenticationManager authenticationManagerBean() throws Exception {
    return super.authenticationManagerBean();
  }

  @Override
  protected void configure(HttpSecurity http) throws Exception {
    http.authorizeRequests()
            .antMatchers("/resources/**", "enregistrement").permitAll()
            .anyRequest()
            .authenticated()
            .and()
            .formLogin()
            .loginPage("/login")
            .permitAll()
            .and()
            .logout()
            .permitAll();
  }

  @Autowired
  public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
<<<<<<< HEAD
    auth.userDetailsService(userDetailsService).passwordEncoder(bCryptPasswordEncoder());
=======
    auth.inMemoryAuthentication().userDetailsService(userDetailsService).passwordEncoder(bCryptPasswordEncoder());
>>>>>>> godzyken
  }
}
