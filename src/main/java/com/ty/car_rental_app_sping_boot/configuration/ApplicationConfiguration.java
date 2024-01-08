package com.ty.car_rental_app_sping_boot.configuration;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Contact;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.info.License;
import io.swagger.v3.oas.models.servers.Server;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.List;

@Configuration
public class ApplicationConfiguration {
    @Bean
    public OpenAPI usersMicroserviceOpenAPI() {

        Server localhost = new Server();
        localhost.setUrl("http://localhost:8080");
        localhost.setDescription("Development environment");
        
        Contact contact = new Contact();
        contact.setEmail("VroomVista@gmail.com");
        contact.setName("VroomVista");
        contact.setUrl("https://vroomVista.in");

        License mitLicense = new License().name("MIT License").url("https://choosealicense.com/licenses/mit/");

        Info info = new Info().title("VroomVista App RESTful Web Service documentation").version("1.0").contact(contact)
                .description("This API exposes endpoints to manage VroomVistaApp.")
                .termsOfService("https://vroomVista.in/terms").license(mitLicense);

        return new OpenAPI().info(info).servers(List.of(localhost));
    }
}
