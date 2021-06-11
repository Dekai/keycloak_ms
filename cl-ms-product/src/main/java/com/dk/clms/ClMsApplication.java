package com.dk.clms;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients
public class ClMsApplication {

    public static void main(String[] args) {
        SpringApplication.run(ClMsApplication.class, args);
    }

}
