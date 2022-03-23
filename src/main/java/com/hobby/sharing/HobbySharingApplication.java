package com.hobby.sharing;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@EnableFeignClients
@SpringBootApplication
public class HobbySharingApplication {

    public static void main(String[] args) {
        SpringApplication.run(HobbySharingApplication.class, args);
    }

}
