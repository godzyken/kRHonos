package com.krhonos.contrat;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;


@EnableConfigurationProperties
@EnableEurekaClient
@SpringBootApplication
public class ContratApplication {

  public static void main(String[] args) {
    SpringApplication.run(ContratApplication.class, args);
  }
}
