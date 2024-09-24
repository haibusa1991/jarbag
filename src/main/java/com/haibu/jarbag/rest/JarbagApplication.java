package com.haibu.jarbag.rest;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(scanBasePackages = "com.haibu.jarbag")
public class JarbagApplication {

    public static void main(String[] args) {
        SpringApplication.run(JarbagApplication.class, args);
    }

}