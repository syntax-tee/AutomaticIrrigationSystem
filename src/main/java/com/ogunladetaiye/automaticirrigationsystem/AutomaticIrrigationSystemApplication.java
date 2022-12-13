package com.ogunladetaiye.automaticirrigationsystem;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.info.License;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class AutomaticIrrigationSystemApplication {

    public static void main(String[] args) {
        SpringApplication.run(AutomaticIrrigationSystemApplication.class, args);
    }

    @Bean
    public OpenAPI customOpenAPI(@Value("${app.description}") String appDescription, @Value("${app.version}") String appVersion) {
        return new OpenAPI().info(new Info()
                .title("Automatic Irrigation  API")
                .version(appVersion).description(appDescription)
                .termsOfService("http://swagger.io/terms").license(new License().name("Apache 2.0").url("http://springdoc.org")));
    }

}
