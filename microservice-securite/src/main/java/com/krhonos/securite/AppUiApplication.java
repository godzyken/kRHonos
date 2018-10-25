package com.krhonos.securite;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients("com.krhonos.securite")
public class AppUiApplication {

  public static void main(String[] args) {
    SpringApplication.run(AppUiApplication.class, args);
  }
}
