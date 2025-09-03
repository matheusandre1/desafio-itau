package com.example.desafio_itau.config.docs;


import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class Docs {

    @Bean
    public OpenAPI customOpenApi()
    {
        return new OpenAPI()
                .info(new Info().title("Desafio Itau")
                        .description("Desafio Técnico Itau Unibanco"));

    }
}
