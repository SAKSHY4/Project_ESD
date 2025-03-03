package com.example.project_esd;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;

@SpringBootApplication(exclude = {SecurityAutoConfiguration.class})
public class ProjectEsdApplication {

    public static void main(String[] args) {
        SpringApplication.run(ProjectEsdApplication.class, args);
    }

}