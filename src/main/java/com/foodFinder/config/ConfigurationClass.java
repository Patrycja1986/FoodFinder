package com.foodFinder.config;

import com.sendgrid.SendGrid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Lazy;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;

@Configuration
public class ConfigurationClass {

   @Value("${spring.sendgrid.api-key}")
   private String apiKey;

    @Bean
    public SendGrid sendGrid() {
       return new SendGrid(apiKey);}
}
