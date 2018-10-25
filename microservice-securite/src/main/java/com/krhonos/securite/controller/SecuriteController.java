package com.krhonos.securite.controller;

import org.apache.catalina.filters.HttpHeaderSecurityFilter;
import org.springframework.boot.autoconfigure.security.servlet.WebSecurityEnablerConfiguration;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.annotation.Order;

@Configuration
@Order(1)
public class SecuriteController extends WebSecurityEnablerConfiguration {

  @Override
  protected void configure(HttpHeaderSecurityFilter securityFilter) {
    // @
  }

}
