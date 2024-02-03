package com.projectoconcesionario.concesionario.config.Swagger;

import io.swagger.v3.oas.models.Components;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Contact;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.info.License;
import io.swagger.v3.oas.models.security.SecurityRequirement;
import io.swagger.v3.oas.models.security.SecurityScheme;
import io.swagger.v3.oas.models.servers.Server;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.Arrays;

@Configuration
public class SwaggerConfig {

    @Value("${server.openapi.dev-url}")
    private String devUrl;

    @Value("${server.openapi.prod-url}")
    private String prodUrl;

    private SecurityScheme createAPIKeyScheme() {
        return new SecurityScheme().type(SecurityScheme.Type.HTTP)
                .bearerFormat("JWT")
                .scheme("bearer");
    }
    @Bean
    public OpenAPI openAPI() {
        return new OpenAPI().addSecurityItem(new SecurityRequirement().
                        addList("Bearer Authentication"))
                .components(new Components().addSecuritySchemes
                        ("Bearer Authentication", createAPIKeyScheme()))
                .info(new Info().title("API REST Demo concesionario")
                        .description("Es una api Demo de una pagina web de un concesionario con autenticación Jwt  .")
                        .version("1.0").contact(new Contact().name("Mohammed El yousfi")
                                .email("mohammedelyousfi3@gmail.com").url("https://mohammedelyousfi.vercel.app/"))
                        .license(new License().name("License of API")
                                .url("API license URL"))
                ).servers(Arrays.asList(new Server().description("Server URL in Production environment").url(prodUrl)
                                ,new Server().description("Server URL in Development environment").url(devUrl)));
    }


}
