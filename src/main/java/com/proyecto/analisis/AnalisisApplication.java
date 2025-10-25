package com.proyecto.analisis;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@SpringBootApplication
public class AnalisisApplication {

	public static void main(String[] args) {
        SpringApplication.run(AnalisisApplication.class, args);
	}

    @Bean
    public WebMvcConfigurer corsConfigurer() {
        return  new WebMvcConfigurer() {
            @Override
            public void addCorsMappings(CorsRegistry registry){
                registry.addMapping("/**").allowedOrigins("http://localhost:5500", "http://proyecto-carrito.local")
                        .allowedMethods("*").allowedHeaders("*").allowCredentials(true);
            }
        };
    }
}
