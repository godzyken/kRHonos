package com.krhonos.app_ui;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients("com.krhonos.app_ui")
public class AppUiApplication {

  public static void main(String[] args) {
    SpringApplication.run(AppUiApplication.class, args);
  }
}
