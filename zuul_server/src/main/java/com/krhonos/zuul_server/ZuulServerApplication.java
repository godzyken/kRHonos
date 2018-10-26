package com.krhonos.zuul_server;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;

@EnableConfigurationProperties
@SpringBootApplication
@EnableEurekaClient
@EnableZuulProxy
public class ZuulServerApplication {

  /**
   * <b>OBJET QUI POSSEDE LES FONCTIONNALITES SUIVANTES : </b> <br/>
   * <br/>
   * Les fonctionnalites d'ecriture de messages de log dans la console.
   */
  private static final Logger LOGGER = LoggerFactory.getLogger(ZuulServerApplication.class);

  public static void main(String[] args) {
    LOGGER.info("CLASS : ZuulServerApplication -- METHOD : main -- BEGIN");
    SpringApplication.run(ZuulServerApplication.class, args);
    LOGGER.info("CLASS : ZuulServerApplication -- METHOD : main -- END");
  }
}
