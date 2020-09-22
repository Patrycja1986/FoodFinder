package com.foodFinder.model.email;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.persistence.Access;

@Component
final class EmailRequestBuilder {

    @Autowired
     private EmailRequestDTO emailRequest;

     private EmailRequestBuilder(){}

     public static EmailRequestBuilder of() {
         return new EmailRequestBuilder();
     }

     public EmailRequestBuilder to(String to) {
         emailRequest.setTo(to);
         return this;
     }

     public EmailRequestBuilder from(String from) {
         emailRequest.setFrom(from);
         return this;
     }

     public EmailRequestBuilder subject(String subject) {
         emailRequest.setSubject(subject);
         return this;
     }

     public EmailRequestBuilder content(String content) {
         emailRequest.setContent(content);
         return this;
     }

     public EmailRequestBuilder templateName(String templateName) {
         emailRequest.setTemplateName(templateName);
         return this;
     }

     public EmailRequestDTO build() {
         return emailRequest;
     }
 }

