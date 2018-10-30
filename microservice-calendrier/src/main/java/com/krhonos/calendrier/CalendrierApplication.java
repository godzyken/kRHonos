package com.krhonos.calendrier;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@EnableConfigurationProperties
@EnableEurekaClient
@SpringBootApplication
public class CalendrierApplication {

    /**
     * <b>OBJET QUI POSSEDE LES FONCTIONNALITES SUIVANTES : </b> <br/>
     * <br/>
     * Les fonctionnalites d'ecriture de messages de log dans la console.
     */
    private static final Logger LOGGER = LoggerFactory.getLogger(CalendrierApplication.class);


    public static void main(String[] args) {

        LOGGER.info("CLASS : CalendrierApplication -- METHOD : main -- BEGIN");
        SpringApplication.run(CalendrierApplication.class, args);
        LOGGER.info("CLASS : CalendrierApplication -- METHOD : main -- END");
    }
}
