package com.stuart.utils;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class CorsConfig implements WebMvcConfigurer{
     
    //como implementamos una interfaz se van a sobre escribir los metodos
    //mapeo a los endpoints
    
    @Override
    public void addCorsMappings(CorsRegistry registry) {
        registry.addMapping("/api/**") // /** para que aplique a todos los endpoints posibles 
        .allowedOrigins("*") //cualquier direccion IP 
        .allowedMethods("GET", "POST", "PUT", "DELETE", "OPTIONS", "HEAD", "TRACE", "CONNECT");
        //SE pueden quitar metodo delete para que no borren 
    }
    
    

}