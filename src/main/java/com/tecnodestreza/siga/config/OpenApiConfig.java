package com.tecnodestreza.siga.config;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Contact;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.servers.Server;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class OpenApiConfig {

    @Value("${server.port:8090}")
    private int serverPort;

    @Bean
    public OpenAPI sigaOpenAPI() {
        return new OpenAPI()
                .info(new Info()
                        .title("SIGA-API")
                        .description("Sistema de Información de Gestión Académica")
                        .version("1.0")
                        .contact(new Contact().name("Tecnodestreza")))
                .addServersItem(new Server()
                        .url("http://localhost:" + serverPort + "/siga/api/v1")
                        .description("Local"));
    }
}
