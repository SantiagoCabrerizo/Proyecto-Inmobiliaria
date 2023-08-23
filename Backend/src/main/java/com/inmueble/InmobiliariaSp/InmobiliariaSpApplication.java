package com.inmueble.InmobiliariaSp;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class InmobiliariaSpApplication {

    public static void main(String[] args) {
        SpringApplication.run(InmobiliariaSpApplication.class, args);
    }

}
