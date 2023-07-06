package com.juliusyolo.yolo.registry;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;
import org.springframework.context.annotation.Profile;

/**
 * @author julius
 */
@SpringBootApplication
@EnableEurekaServer
public class YoloRegistryApplication {

  public static void main(String[] args) {
    SpringApplication.run(YoloRegistryApplication.class, args);
  }

}
