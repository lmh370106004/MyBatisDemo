package com.lmh.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * Created by liumuhang on 2018/6/24.
 */

@SpringBootApplication(scanBasePackages = "com.lmh")
public class Application {

  public static void main(String[] args) {
    SpringApplication.run(Application.class, args);
  }
}
