package com.krhonos.etablissement;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

//@EnableJpaRepositories(basePackages = "com.krhonos.etablissement.dao")
@SpringBootApplication
public class EtablissementApplication {

  public static void main(String[] args) {
    SpringApplication.run(EtablissementApplication.class, args);
  }
}
