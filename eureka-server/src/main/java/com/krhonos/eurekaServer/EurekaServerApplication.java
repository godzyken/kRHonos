package com.krhonos.eurekaServer;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;


@SpringBootApplication
@EnableEurekaServer
public class EurekaServerApplication {

  /**
   * <b>OBJET QUI POSSEDE LES FONCTIONNALITES SUIVANTES : </b> <br/>
   * <br/>
   * Les fonctionnalites d'ecriture de messages de log dans la console.
   */
  private static final Logger LOGGER = LoggerFactory.getLogger(EurekaServerApplication.class);

  public static void main(String[] args) {
    LOGGER.info("CLASS : EurekaServerApplication -- METHOD : main -- BEGIN");
    SpringApplication.run(EurekaServerApplication.class, args);
    LOGGER.info("CLASS : EurekaServerApplication -- METHOD : main -- END");
  }
}
