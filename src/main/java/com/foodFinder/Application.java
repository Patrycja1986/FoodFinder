package com.foodFinder;

import com.foodFinder.service.email.EmailService;
import com.foodFinder.service.email.SendGridEmailService;
import com.sendgrid.SendGrid;
import com.sendgrid.SendGridAPI;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.sendgrid.SendGridAutoConfiguration;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.io.IOException;
import java.net.URISyntaxException;

@SpringBootApplication
public class Application {


    public static void main(String[] args) throws IOException {
        ConfigurableApplicationContext app=SpringApplication.run(Application.class, args);
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
