package com.krhonos.calendar;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@EnableEurekaClient
@SpringBootApplication
public class CalendarApplication {

  /**
   * <b>OBJET QUI POSSEDE LES FONCTIONNALITES SUIVANTES : </b> <br/>
   * <br/>
   * Les fonctionnalites d'ecriture de messages de log dans la console.
   */
  private static final Logger LOGGER = LoggerFactory.getLogger(CalendarApplication.class);


  public static void main(String[] args) {
    LOGGER.info("CLASS : CalendarApplication -- METHOD : main -- BEGIN");
    SpringApplication.run(CalendarApplication.class, args);
    LOGGER.info("CLASS : CalendarApplication -- METHOD : main -- END");

  }
}
