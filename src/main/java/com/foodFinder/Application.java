package com.foodFinder;

import com.foodFinder.service.email.SendGridEmailService;
import com.sendgrid.SendGrid;
import com.sendgrid.SendGridAPI;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.sendgrid.SendGridAutoConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import java.io.IOException;

@SpringBootApplication
public class Application {
    public static void main(String[] args) throws IOException {
       SpringApplication.run(Application.class, args);
        SendGridEmailService emailService= new SendGridEmailService();
        emailService.sendText("patrycja.guz1986@gmail.com","patrycja.guz1986@gmail.com","dupa","dupa");
    }

    @Bean
    public WebMvcConfigurer corsConfigurer() {
        return new WebMvcConfigurer() {
            @Override
            public void addCorsMappings(CorsRegistry registry) {
                registry.addMapping("/**").allowedMethods("HEAD","POST","GET","PUT","PATCH","DELETE");
            }
        };
    }
    @Bean
    public ModelMapper modelMapper() {
        return new ModelMapper();
    }

}
