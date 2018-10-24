package com.krhonos.salaried;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@EnableEurekaClient
@SpringBootApplication
public class SalariedApplication {

  /**
   * <b>OBJET QUI POSSEDE LES FONCTIONNALITES SUIVANTES : </b> <br/>
   * <br/>
   * Les fonctionnalites d'ecriture de messages de log dans la console.
   */
  private static final Logger LOGGER = LoggerFactory.getLogger(SalariedApplication.class);


  public static void main(String[] args) {
    LOGGER.info("CLASS : SalariedApplication -- METHOD : main -- BEGIN");
    SpringApplication.run(SalariedApplication.class, args);
    LOGGER.info("CLASS : SalariedApplication -- METHOD : main -- END");

  }
}
