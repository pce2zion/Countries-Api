package com.example.CountriesApi.config;

import io.swagger.v3.oas.annotations.ExternalDocumentation;
import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Contact;
import io.swagger.v3.oas.annotations.info.License;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;

import java.util.Collections;

@Configuration
//@OpenAPIDefinition(
//info = @Info(
//        title="CountriesApi",
//        description = "An APi that gives countries population, cities and states",
//        version = "v1.0",
//        contact = @Contact(
//                name = "Obute Peace",
//                email = "peaceobute65@gmail.com"
//                ),
//        license = @License(
//                name = "Apache 2.0"
//        )
//    ),
//        externalDocs = @ExternalDocumentation(
//                description =  "Countries and Cities Api",
//                url = "https://documenter.getpostman.com/view/1134062/T1LJjU52#intro"
//        )
//
//        )
public class SwaggerConfig {
    @Bean
    public Docket api() {
        return new Docket(DocumentationType.SWAGGER_2)
                .select()
                .apis(RequestHandlerSelectors.any())
                .paths(PathSelectors.any())
                .build();
    }

    public OpenAPI bankAPI() {
        return new OpenAPI()
                .info(new Info()
                        .title("Drone API ")
                        .description("DecaPay is a personal finance tracker that helps you keep track of your budget.")
                        .version("1.11")

                );

    }
    }